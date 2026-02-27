package com.jujus.flash_stock.features.home.domain.entities


data class OfferDetail(
    val id: String,
    val name: String,
    val description: String,
    val photoUrl: String,
    val initialPrice: Double,
    val currentPrice: Double,
    val stock: Int,
    val status: String,
    val endTime: String,
    val viewers: Int = 0
)