package com.jujus.flash_stock.features.store.data.datasources.remote.models

import kotlinx.serialization.SerialName

data class OffersDto(
    val id: String,
    @SerialName("store_id") val storeId: String,
    @SerialName("category_id") val categoryId: String,
    val name: String,
    val description: String,
    @SerialName("photo_url") val photoUrl: String?,
    @SerialName("initial_price") val initialPrice: Double,
    @SerialName("min_price") val minPrice: Double,
    @SerialName("current_price") val currentPrice: Double,
    val stock: Int,
    @SerialName("start_time") val startTime: String,
    @SerialName("end_time") val endTime: String,
    val status: String,
)
