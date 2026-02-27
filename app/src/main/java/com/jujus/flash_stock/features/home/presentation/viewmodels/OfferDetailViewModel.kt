package com.jujus.flash_stock.features.home.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujus.flash_stock.features.home.domain.usecases.GetOfferDetailUseCase
import com.jujus.flash_stock.features.home.domain.usecases.ManageOfferSocketUseCase
import com.jujus.flash_stock.features.home.presentation.screens.OfferDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.time.LocalDateTime
import java.time.Duration
import java.time.format.DateTimeFormatter

@HiltViewModel
class OfferDetailViewModel @Inject constructor(
    private val getOfferDetailUseCase: GetOfferDetailUseCase,
    private val manageSocketUseCase: ManageOfferSocketUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow(OfferDetailUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    // sharedFlow para eventos de un solo disparo como alertas o disparos
    private val _eventFlow = MutableSharedFlow<String>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun loadOffer(offerId: String) {
        viewModelScope.launch {
            manageSocketUseCase.connect(offerId)

            getOfferDetailUseCase(offerId).collect { offer ->
                // Agrega este Log para ver si el ViewModel se entera
                Log.d("VM_CHECK", "Nuevo precio en VM: ${offer.currentPrice}")

                _uiState.update { currentState ->
                    currentState.copy(
                        currentPrice = offer.currentPrice,
                        stock = offer.stock,
                        viewers = offer.viewers,
                        timeLeft = formatTimeLeft(offer.endTime),
                        isLoading = false
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

    private fun formatTimeLeft(endsAt: String): String {
        return try {
            val formatter = DateTimeFormatter.ISO_DATE_TIME
            val endDate = java.time.ZonedDateTime.parse(endsAt).toLocalDateTime()
            val now = LocalDateTime.now()
            val duration = Duration.between(now, endDate)

            if (duration.isNegative || duration.isZero) return "¡TERMINÓ!"

            val hours = duration.toHours()
            val minutes = duration.toMinutes() % 60
            val seconds = duration.seconds % 60

            if (hours > 0) {
                String.format("%02d:%02d:%02d", hours, minutes, seconds)
            } else {
                String.format("%02d:%02d", minutes, seconds)
            }
        } catch (e: Exception) {
            "Expira pronto"
        }
    }
}