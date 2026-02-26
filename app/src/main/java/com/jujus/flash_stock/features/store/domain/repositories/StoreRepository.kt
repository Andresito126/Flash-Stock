package com.jujus.flash_stock.features.store.domain.repositories

import com.jujus.flash_stock.features.store.domain.entities.CreateOfferRequest
import com.jujus.flash_stock.features.store.domain.entities.Offer

interface StoreRepository {
    suspend fun getStoreOffers(): Result<List<Offer>>
    suspend fun createOffer(offer: CreateOfferRequest): Result<Unit>
}