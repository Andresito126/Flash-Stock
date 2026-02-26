package com.jujus.flash_stock.features.store.domain.entities

class CreateOfferRequest (
    val name: String,
    val description: String,
    val categoryId: String,
    val initialPrice: Double,
    val minPrice: Double,
    val stock: Int,
    val startTime: String,
    val endTime: String
)