package com.jujus.flash_stock.features.store.presentation.screens

data class CreateOfferUiState(
    val name: String = "",
    val description: String = "",
    val initialPrice: String = "",
    val minPrice: String = "",
    val stock: String = "",
    val categoryId: String = "1352e6f5-1e2e-4a33-8306-d18aafdbc95d",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false
)