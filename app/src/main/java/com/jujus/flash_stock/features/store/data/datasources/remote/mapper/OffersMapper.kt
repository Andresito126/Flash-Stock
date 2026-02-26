package com.jujus.flash_stock.features.store.data.datasources.remote.mapper

import com.jujus.flash_stock.features.store.data.datasources.remote.models.OffersDto
import com.jujus.flash_stock.features.store.domain.entities.Offer

fun OffersDto.toDomain(): Offer{
    return Offer(
        id= this.id,
        storeId = this.storeId,
        categoryId = this.categoryId,
        name = this.name,
        description = this.description,
        photoUrl = this.photoUrl,
        initialPrice = this.initialPrice,
        minPrice = this.minPrice,
        currentPrice = this.currentPrice,
        stock = this.stock,
        startTime = this.startTime,
        endTime = this.endTime,
        status = this.status

    )
}
