package com.jujus.flash_stock.features.home.presentation.screens

import com.jujus.flash_stock.features.home.domain.entities.HomeOffer

data class HomeUiState(
    val isLoading: Boolean = false,
    val offers: List<HomeOffer> = emptyList(),
    val error: String? = null
)