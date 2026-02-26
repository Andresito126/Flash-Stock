package com.jujus.flash_stock.features.store.data.datasources.remote.api

import com.jujus.flash_stock.features.store.data.datasources.remote.models.CreateOfferDto
import com.jujus.flash_stock.features.store.data.datasources.remote.models.GenericResponse
import com.jujus.flash_stock.features.store.data.datasources.remote.models.OffersDto
import com.jujus.flash_stock.features.store.data.datasources.remote.models.OffersResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FlashStockApi {
    @GET(value = "/api/offers/store/mine")
    suspend fun getStoreOffers(): OffersResponse

    @POST("api/offers")
    suspend fun createOffer(
        @Body offer: CreateOfferDto
    ): GenericResponse

}