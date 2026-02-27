package com.jujus.flash_stock.features.store.domain.usecases

import com.jujus.flash_stock.features.store.domain.repositories.StoreRepository
import javax.inject.Inject

class CancelOfferUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    suspend operator fun invoke(id: String) = repository.cancelOffer(id)
}