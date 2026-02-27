package com.jujus.flash_stock.features.store.data.datasources.remote.models

import com.google.gson.annotations.SerializedName

class CreateOfferDto(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("category_id") val categoryId: String,
    @SerializedName("initial_price") val initialPrice: Double,
    @SerializedName("min_price") val minPrice: Double,
    @SerializedName("stock") val stock: Int,
    @SerializedName("start_time") val startTime: String,
    @SerializedName("end_time") val endTime: String
)