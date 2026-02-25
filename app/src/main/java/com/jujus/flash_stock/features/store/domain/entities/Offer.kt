package com.jujus.flash_stock.features.store.domain.entities

data class Offer(
    val id: Int,
    val name: String,
    val description: String,
    val currentPrice: Double,
    val stock: Int,
    val status: String,
    val photoUrl: String?
)
