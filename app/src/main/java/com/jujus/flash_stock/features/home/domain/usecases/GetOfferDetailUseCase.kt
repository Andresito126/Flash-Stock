package com.jujus.flash_stock.features.home.domain.usecases

import com.jujus.flash_stock.features.home.domain.entities.OfferDetail
import com.jujus.flash_stock.features.home.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOfferDetailUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    operator fun invoke(id: String): Flow<OfferDetail> {
        return repository.getOfferDetail(id)
    }
}