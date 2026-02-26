package com.jujus.flash_stock.features.store.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujus.flash_stock.features.store.domain.usecases.GetStoreOffersUseCase
import com.jujus.flash_stock.features.store.presentation.screens.StoreUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreScreenViewModel @Inject constructor(
    private val getStoreOffersUseCase: GetStoreOffersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(StoreUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadOffers()
    }

    fun loadOffers() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val result = getStoreOffersUseCase()
            result.fold(
                onSuccess = { list ->
                    _uiState.update { it.copy(isLoading = false, offer = list, error = null) }
                },
                onFailure = { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message) }
                }
            )
        }
    }
}


