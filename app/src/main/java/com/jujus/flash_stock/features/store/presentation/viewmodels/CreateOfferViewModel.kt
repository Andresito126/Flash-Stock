package com.jujus.flash_stock.features.store.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujus.flash_stock.features.store.domain.entities.CreateOfferRequest
import com.jujus.flash_stock.features.store.domain.usecases.CreateOfferRequestUseCase
import com.jujus.flash_stock.features.store.presentation.screens.CreateOfferUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import java.time.Instant


@HiltViewModel
class CreateOfferViewModel @Inject constructor(
    private val createOfferUseCase: CreateOfferRequestUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CreateOfferUiState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(value: String) = _uiState.update { it.copy(name = value) }
    fun onDescriptionChange(value: String) = _uiState.update { it.copy(description = value) }
    fun onInitialPriceChange(value: String) = _uiState.update { it.copy(initialPrice = value) }
    fun onMinPriceChange(value: String) = _uiState.update { it.copy(minPrice = value) }
    fun onStockChange(value: String) = _uiState.update { it.copy(stock = value) }
    fun onCategoryChange(value: String) = _uiState.update { it.copy(categoryId = value) }


    fun createOffer() {
        val state = _uiState.value

        if (state.name.isBlank() || state.initialPrice.isBlank() || state.minPrice.isBlank()) {
            _uiState.update { it.copy(errorMessage = "Por favor, llena todos los campos") }
            return
        }

        val iPrice = state.initialPrice.toDoubleOrNull() ?: 0.0
        val mPrice = state.minPrice.toDoubleOrNull() ?: 0.0

        val now = Instant.now().minus(1, ChronoUnit.MINUTES)
        val oneHourLater = now.plus(1, ChronoUnit.HOURS)

        if (mPrice >= iPrice) {
            _uiState.update { it.copy(errorMessage = "El precio mínimo debe ser menor al inicial") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            val request = CreateOfferRequest(
                name = state.name,
                description = state.description,
                categoryId = state.categoryId,
                initialPrice = iPrice,
                minPrice = mPrice,
                stock = state.stock.toIntOrNull() ?: 1,
                startTime = now.toString(),
                endTime = oneHourLater.toString()
            )

            createOfferUseCase(request).fold(
                onSuccess = {
                    _uiState.update { it.copy(isLoading = false, isSuccess = true) }
                },
                onFailure = { error ->
                    _uiState.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
            )
        }
    }
}