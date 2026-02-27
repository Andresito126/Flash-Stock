package com.jujus.flash_stock.features.home.data.datasources.remote.models

import com.jujus.flash_stock.features.home.domain.entities.OfferDetail

data class OfferStateDto(
    val offerId: String,
    val currentPrice: Double,
    val stock: Int,
    val status: String,
    val endsAt: String,
    val startsAt: String,
    val viewers: Int = 0
)

data class ViewerCountDto(
    val offerId: String,
    val count: Int
)