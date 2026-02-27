package com.jujus.flash_stock.features.home.data.datasources


import com.jujus.flash_stock.features.home.data.datasources.local.entities.HomeOfferEntity
import com.jujus.flash_stock.features.home.data.datasources.remote.models.HomeOfferDto
import com.jujus.flash_stock.features.home.domain.entities.HomeOffer

// de api a bd el ssto
fun HomeOfferDto.toEntity(): HomeOfferEntity = HomeOfferEntity(
    id = id,
    storeId = store.id,
    categoryId = category.id,
    name = name,
    description = description,
    photoUrl = photoUrl,
    initialPrice = initialPrice.toDoubleOrNull() ?: 0.0,
    minPrice = minPrice.toDoubleOrNull() ?: 0.0,
    currentPrice = currentPrice.toDoubleOrNull() ?: 0.0,
    stock = stock,
    endTime = endTime,
    status = status,
    storeName = store.storeName,
    city = store.city,
    categoryName = category.name
)

// de bd a domain, lo que se ve
fun HomeOfferEntity.toDomain(): HomeOffer = HomeOffer(
    id = id,
    storeId = storeId,
    name = name,
    description = description,
    photoUrl = photoUrl,
    initialPrice = initialPrice,
    minPrice = minPrice,
    currentPrice = currentPrice,
    stock = stock,
    endTime = endTime,
    status = status,
    storeName = storeName,
    storeCity = city,
    categoryName = categoryName
)