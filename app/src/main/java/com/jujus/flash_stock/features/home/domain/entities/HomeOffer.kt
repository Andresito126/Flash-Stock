package com.jujus.flash_stock.features.home.domain.entities

data class HomeOffer(
    val id: String,
    val storeId: String,
    val name: String,
    val description: String,
    val photoUrl: String?,
    val initialPrice: Double,
    val minPrice: Double,
    val currentPrice: Double,
    val stock: Int,
    val endTime: String,
    val status: String,

    val storeName: String,
    val storeCity: String,
    val categoryName: String
)