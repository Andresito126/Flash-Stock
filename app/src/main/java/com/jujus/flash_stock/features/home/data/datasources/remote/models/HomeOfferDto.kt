package com.jujus.flash_stock.features.home.data.datasources.remote.models

import com.google.gson.annotations.SerializedName

data class HomeOfferResponse(
    val success: Boolean,
    val data: HomeOfferData
)


data class HomeOfferData(
    val offers: List<HomeOfferDto>
)


data class HomeOfferDto(
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
    @SerializedName("end_time") val endTime: String,
    val status: String,
    val store: HomeStoreDto,
    val category: HomeCategoryDto
)


data class HomeStoreDto(
    val id: String,
    @SerializedName("store_name") val storeName: String,
    val city: String
)


data class HomeCategoryDto(
    val id: String,
    val name: String
)