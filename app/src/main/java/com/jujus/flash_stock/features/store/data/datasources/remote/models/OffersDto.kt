package com.jujus.flash_stock.features.store.data.datasources.remote.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class OffersDto(
    val id: String,
    @SerializedName("store_id") val storeId: String,
    @SerializedName("category_id") val categoryId: String,
    val name: String,
    val description: String,
    @SerializedName("photo_url") val photoUrl: String?,
    @SerializedName("initial_price") val initialPrice: String,
    @SerializedName("min_price") val minPrice: String,
    @SerializedName("current_price") val currentPrice: String,
    val stock: Int,
    @SerializedName("start_time") val startTime: String,
    @SerializedName("end_time") val endTime: String,
    val status: String,
)
