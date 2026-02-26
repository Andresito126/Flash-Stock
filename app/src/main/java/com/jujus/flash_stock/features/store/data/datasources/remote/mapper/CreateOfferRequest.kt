package com.jujus.flash_stock.features.store.data.datasources.remote.mapper

import com.jujus.flash_stock.features.store.data.datasources.remote.models.CreateOfferDto
import com.jujus.flash_stock.features.store.domain.entities.CreateOfferRequest

fun CreateOfferRequest.toDto() = CreateOfferDto(
    name = this.name,
    description = this.description,
    categoryId = this.categoryId,
    initialPrice = this.initialPrice,
    minPrice = this.minPrice,
    stock = this.stock,
    startTime = this.startTime,
    endTime = this.endTime
)