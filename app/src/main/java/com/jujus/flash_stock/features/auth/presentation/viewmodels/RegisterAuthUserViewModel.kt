package com.jujus.flash_stock.features.auth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujus.flash_stock.core.components.AuthRole
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserRequest
import com.jujus.flash_stock.features.auth.domain.usecases.UserRegisterUseCase
import com.jujus.flash_stock.features.auth.presentation.screens.RegisterAuthUserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterAuthUserViewModel @Inject constructor(
    private val userRegisterUseCase: UserRegisterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterAuthUserUiState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(value: String) {
        _uiState.update { it.copy(name = value, error = null) }
    }

    fun onEmailChange(value: String) {
        _uiState.update { it.copy(email = value, error = null) }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { it.copy(password = value, error = null) }
    }

    fun onRoleChange(role: AuthRole) {
        _uiState.update { it.copy(selectedRole = role) }
    }
    fun onPhoneChange(value: String) {
        _uiState.update { it.copy(phone = value, error = null) }
    }

    fun onRegisterClick() {
        val state = _uiState.value

        if (state.name.isBlank() || state.email.isBlank() || state.password.isBlank()) {
            _uiState.update { it.copy(error = "Completa todos los campos") }
            return
        }

        if (state.password.length < 6) {
            _uiState.update { it.copy(error = "La contraseña debe tener al menos 6 caracteres") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            // Divide el nombre en name y last_name
            val nameParts = state.name.trim().split(" ", limit = 2)
            val firstName = nameParts.getOrElse(0) { "" }
            val lastName = nameParts.getOrElse(1) { "" }

            val request = RegisterUserRequest(
                name = firstName,
                lastName = lastName,
                email = state.email,
                password = state.password,
                phone = state.phone,
                isActive = true
            )

            val result = userRegisterUseCase(request)

            result.fold(
                onSuccess = {
                    _uiState.update { it.copy(isLoading = false, isRegisterSuccessful = true) }
                },
                onFailure = { e ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = e.message ?: "Error al crear cuenta"
                        )
                    }
                }
            )
        }
    }
}