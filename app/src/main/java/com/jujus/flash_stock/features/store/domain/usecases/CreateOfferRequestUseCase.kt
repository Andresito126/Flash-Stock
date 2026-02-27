package com.jujus.flash_stock.features.store.domain.usecases

import com.jujus.flash_stock.features.store.domain.entities.CreateOfferRequest
import com.jujus.flash_stock.features.store.domain.repositories.StoreRepository
import javax.inject.Inject

class CreateOfferRequestUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    suspend operator fun invoke(offer: CreateOfferRequest): Result<Unit> {
        return repository.createOffer(offer)
    }
}