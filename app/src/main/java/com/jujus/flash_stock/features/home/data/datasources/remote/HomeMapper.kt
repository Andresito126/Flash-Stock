package com.jujus.flash_stock.features.home.data.datasources.remote

import com.jujus.flash_stock.features.home.data.datasources.remote.models.OfferStateDto
import com.jujus.flash_stock.features.home.domain.entities.OfferDetail


fun OfferStateDto.toDomain(): OfferDetail {
    return OfferDetail(
        id = this.offerId,
        name = "",
        description = "",
        photoUrl = "",
        initialPrice = 0.0,
        currentPrice = this.currentPrice,
        stock = this.stock,
        status = this.status,
        endTime = this.endsAt,
        viewers = this.viewers
    )
}