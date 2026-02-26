package com.jujus.flash_stock.features.home.data.datasources.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.jujus.flash_stock.features.home.data.datasources.local.entities.HomeOfferEntity
import kotlinx.coroutines.flow.Flow

//el dao data object access es el que tiene las consultas a la base de datos
//se envuleve en un flow paea que sea progrmacion reatciva
@Dao
interface HomeOfferDao {

    // aca la ui observa este flow y reacciona a cualquier cambio
    @Query("SELECT * FROM home_offers WHERE status = 'ACTIVE' ORDER BY endTime ASC")
    fun getAllActiveOffers(): Flow<List<HomeOfferEntity>>

    // para ws
    @Query("UPDATE home_offers SET currentPrice = :newPrice, stock = :newStock WHERE id = :offerId")
    suspend fun updatePriceAndStock(offerId: String, newPrice: Double, newStock: Int)

    @Upsert
    suspend fun insertOffers(offers: List<HomeOfferEntity>)

    @Query("DELETE FROM home_offers")
    suspend fun clearAllOffers()
}