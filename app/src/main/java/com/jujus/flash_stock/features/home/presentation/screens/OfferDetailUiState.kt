package com.jujus.flash_stock.features.home.presentation.screens

data class OfferDetailUiState(
    val isLoading: Boolean = false,
    val offerName: String = "",
    val description: String = "",
    val photoUrl: String = "",
    val initialPrice: Double = 0.0,
    val currentPrice: Double = 0.0,
    val stock: Int = 0,
    val timeLeft: String = "00:00",
    val viewers: Int = 0,
    val error: String? = null,
)