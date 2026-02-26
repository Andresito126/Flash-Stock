package com.jujus.flash_stock.features.store.domain.entities

data class Offer(
    val id: String,
    val storeId: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val photoUrl: String?,
    val initialPrice: Double,
    val minPrice: Double,
    val currentPrice: Double,
    val stock: Int,
    val startTime: String,
    val endTime: String,
    val status: String
)
