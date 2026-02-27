package com.jujus.flash_stock.features.home.data.repositories


import com.jujus.flash_stock.features.home.data.datasources.local.HomeOfferDao
import com.jujus.flash_stock.features.home.data.datasources.remote.OfferSocketManager
import com.jujus.flash_stock.features.home.data.datasources.remote.api.HomeApi
import com.jujus.flash_stock.features.home.data.datasources.remote.toDomain
import com.jujus.flash_stock.features.home.data.datasources.toDomain
import com.jujus.flash_stock.features.home.data.datasources.toEntity
import com.jujus.flash_stock.features.home.domain.entities.HomeOffer
import com.jujus.flash_stock.features.home.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.jujus.flash_stock.features.home.domain.entities.OfferDetail
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: HomeApi,
    private val dao: HomeOfferDao,
    private val socketManager: OfferSocketManager
) : HomeRepository {

    // la ui observa el slow que viene del rom, dond se hace ssto
    override fun getActiveOffersFlow(): Flow<List<HomeOffer>> {
        return dao.getAllActiveOffers().map { entities ->
            entities.map { it.toDomain() } // Convertimos de DB a Domain
        }
    }

    // refresch
    override suspend fun fetchActiveOffers(city: String?, categoryId: String?): Result<Unit> {
        return try {
            val response = api.getActiveOffers(city = city, categoryId = categoryId)

            if (response.success) {
                val entities = response.data.offers.map { it.toEntity() }

                dao.clearAllOffers()
                dao.insertOffers(entities)

                Result.success(Unit)
            } else {
                Result.failure(Exception("Error del servidor: success false"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

//sockttt
override fun getOfferDetail(id: String): Flow<OfferDetail> {
    return socketManager.observeOfferState(
        offerId = id,
        userId = "22d64d8bf-a494-4928-8e3c-35833ec097f2"
    ).map { it.toDomain() }
}
    override suspend fun listenToOfferUpdates(id: String) {
        socketManager.connect()
    }

    override suspend fun leaveOfferUpdates(id: String) {
    }

}