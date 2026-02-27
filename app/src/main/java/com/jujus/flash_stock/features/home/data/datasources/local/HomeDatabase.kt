package com.jujus.flash_stock.features.home.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jujus.flash_stock.features.home.data.datasources.local.entities.HomeOfferEntity

@Database(
    entities = [HomeOfferEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HomeDatabase : RoomDatabase() {
    abstract fun homeOfferDao(): HomeOfferDao
}