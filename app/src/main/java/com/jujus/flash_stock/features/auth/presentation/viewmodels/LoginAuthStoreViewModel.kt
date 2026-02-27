package com.jujus.flash_stock.features.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujus.flash_stock.core.components.AuthRole
import com.jujus.flash_stock.features.auth.domain.usecases.StoreLoginUseCase
import com.jujus.flash_stock.features.auth.domain.usecases.UserLoginUseCase
import com.jujus.flash_stock.features.auth.presentation.screens.LoginAuthStoreUiState
import com.jujus.flash_stock.features.auth.presentation.screens.LoginAuthUserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginAuthStoreViewModel @Inject constructor(
    private val storeLoginUseCase: StoreLoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginAuthStoreUiState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChange(value: String) {
        _uiState.update { it.copy(email = value, error = null) }
    }

    fun onRoleChange(role: AuthRole) {
        _uiState.update { it.copy(selectedRole = role) }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { it.copy(password = value, error = null) }
    }

    fun onLoginClick() {
        val state = _uiState.value

        if (state.email.isBlank() || state.password.isBlank()) {
            _uiState.update { it.copy(error = "Completa todos los campos") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            val result = storeLoginUseCase(state.email, state.password)

            result.fold(
                onSuccess = {
                    _uiState.update { it.copy(isLoading = false, isLoginSuccessful = true) }
                },
                onFailure = { e ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = e.message ?: "Error al iniciar sesión"
                        )
                    }
                }
            )
        }
    }
}