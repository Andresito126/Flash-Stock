package com.jujus.flash_stock.features.store.domain.usecases

import com.jujus.flash_stock.features.store.domain.entities.Offer
import com.jujus.flash_stock.features.store.domain.repositories.StoreRepository

class GetStoreOffersUseCase (private val repository : StoreRepository) {

    suspend operator fun invoke(): Result<List<Offer>> {
        return repository.getMyStoreOffers()
    }
}