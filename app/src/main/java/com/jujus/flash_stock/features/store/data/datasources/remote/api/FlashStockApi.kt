package com.jujus.flash_stock.features.store.data.datasources.remote.api

import com.jujus.flash_stock.features.store.data.datasources.remote.models.OffersDto
import com.jujus.flash_stock.features.store.data.datasources.remote.models.OffersResponse
import retrofit2.http.GET

interface FlashStockApi {
    @GET(value = "/api/offers/store/mine")
    suspend fun getStoreOffers(): OffersResponse
}