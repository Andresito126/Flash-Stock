package com.jujus.flash_stock.features.store.data.repositories

import com.jujus.flash_stock.features.store.data.datasources.remote.api.FlashStockApi
import com.jujus.flash_stock.features.store.data.datasources.remote.mapper.toDomain
import com.jujus.flash_stock.features.store.data.datasources.remote.mapper.toDto
import com.jujus.flash_stock.features.store.domain.entities.CreateOfferRequest
import com.jujus.flash_stock.features.store.domain.entities.Offer
import com.jujus.flash_stock.features.store.domain.repositories.StoreRepository
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
        private val api: FlashStockApi
): StoreRepository {

    override suspend fun getStoreOffers(): Result<List<Offer>>{
        return try {
            val response = api.getStoreOffers()
            if (response.success) {
                Result.success(response.data.offers.map { it.toDomain() })
            } else {
                Result.failure(Exception("Error al obtener ofertas de la tienda"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun createOffer(offer: CreateOfferRequest): Result<Unit> {
        return try {
            val response = api.createOffer(offer.toDto())
            if (response.success) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun cancelOffer(id: String): Result<Unit> {
        return try {
            val response = api.cancelOffer(id)
            if (response.success) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}