package com.jujus.flash_stock.features.store.domain.usecases

import com.jujus.flash_stock.features.store.domain.entities.Offer
import com.jujus.flash_stock.features.store.domain.repositories.StoreRepository
import javax.inject.Inject

class GetStoreOffersUseCase @Inject constructor(
    private val repository: StoreRepository
) {

    suspend operator fun invoke(): Result<List<Offer>> {
        val result = repository.getStoreOffers()

        return result.map { offers ->
            val filteredOffers = offers.filter { it.name.isNotBlank() }
            if (filteredOffers.isEmpty()) {
                throw Exception("No se encontraron ofertas válidas")
            }
            filteredOffers
        }

    }
}
