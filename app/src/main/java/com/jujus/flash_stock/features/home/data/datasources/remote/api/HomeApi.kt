package com.jujus.flash_stock.features.home.data.datasources.remote.api

import com.jujus.flash_stock.features.home.data.datasources.remote.models.HomeOfferResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("api/offers")
    suspend fun getActiveOffers(
        @Query("city") city: String? = "Tuxtla Gutiérrez",
        @Query("category_id") categoryId: String? = null,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): HomeOfferResponse


    @GET("api/offers/{id}")
    suspend fun getOfferById(
        @retrofit2.http.Path("id") id: String
    ): HomeOfferResponse
}