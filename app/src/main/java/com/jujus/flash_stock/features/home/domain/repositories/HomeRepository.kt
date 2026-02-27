package com.jujus.flash_stock.features.home.domain.repositories

import com.jujus.flash_stock.features.home.domain.entities.HomeOffer
import com.jujus.flash_stock.features.home.domain.entities.OfferDetail
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    // para el ssto, lo que viene del room despues
    fun getActiveOffersFlow(): Flow<List<HomeOffer>>

    //para tener datos actualizados
    suspend fun fetchActiveOffers(
        city: String? = "Tuxtla Gutiérrez",
        categoryId: String? = null
    ): Result<Unit>

    fun getOfferDetail(id: String): Flow<OfferDetail>
    suspend fun listenToOfferUpdates(id: String)
    suspend fun leaveOfferUpdates(id: String)

}