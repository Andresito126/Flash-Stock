package com.jujus.flash_stock.features.store.presentation.screens

data class CreateOfferUiState(
    val name: String = "",
    val description: String = "",
    val initialPrice: String = "",
    val minPrice: String = "",
    val stock: String = "",
    val categoryId: String = "1352e6f5-1e2e-4a33-8306-d18aafdbc95d",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)

data class Category(val id: String, val name: String)

val storeCategories = listOf(
    Category("b64f27cb-4903-4fa3-9b94-f747931858ab", "Panadería y Repostería"),
    Category("1352e6f5-1e2e-4a33-8306-d18aafdbc95d", "Postres y Helados"),
    Category("91adbf77-d9fa-4ef2-a3cb-d0ce50ceca4c", "Bebidas"),
    Category("c0cf2025-634f-4280-9be0-af8a0498d36f", "Frutas y Verduras")
)