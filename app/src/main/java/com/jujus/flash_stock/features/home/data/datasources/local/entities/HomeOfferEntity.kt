package com.jujus.flash_stock.features.home.data.datasources.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "home_offers")
data class HomeOfferEntity(
    @PrimaryKey
    val id: String,
    val storeId: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val photoUrl: String?,
    val initialPrice: Double,
    val currentPrice: Double,
    val stock: Int,
    val endTime: String,
    val status: String,
    val storeName: String,
    val city: String,
    val categoryName: String
)