package com.jujus.flash_stock.features.home.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jujus.flash_stock.features.home.domain.repositories.HomeRepository
import com.jujus.flash_stock.features.home.domain.usecases.GetActiveOffersUseCase
import com.jujus.flash_stock.features.home.domain.usecases.RefreshHomeOffersUseCase
import com.jujus.flash_stock.features.home.presentation.screens.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getActiveOffersUseCase: GetActiveOffersUseCase,
    private val refreshHomeOffersUseCase: RefreshHomeOffersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        //empeiza a observar ssto o sea el roomm
        observeOffers()
        // para pedir datos frescos a la api
        refreshOffers()
    }

    private fun observeOffers() {
        viewModelScope.launch {
            //esucha room
            getActiveOffersUseCase().collect { offersList ->
                _uiState.update { it.copy(offers = offersList) }
            }
        }
    }


    fun refreshOffers(categoryId: String? = null) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            // y este para internet
            val result = refreshHomeOffersUseCase(categoryId = categoryId)

            result.onSuccess {
                _uiState.update { it.copy(isLoading = false, error = null) }
            }.onFailure { e ->
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}