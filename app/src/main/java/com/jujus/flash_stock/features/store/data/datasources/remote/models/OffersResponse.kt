package com.jujus.flash_stock.features.store.data.datasources.remote.models

data class OffersResponse(
    val success: Boolean,
    val data: StoreOffersData
)

data class StoreOffersData(
    val offers: List<OffersDto>
)

