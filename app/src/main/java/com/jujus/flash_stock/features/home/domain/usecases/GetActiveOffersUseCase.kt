package com.jujus.flash_stock.features.home.domain.usecases

import com.jujus.flash_stock.features.home.domain.entities.HomeOffer
import com.jujus.flash_stock.features.home.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActiveOffersUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    operator fun invoke(): Flow<List<HomeOffer>> = repository.getActiveOffersFlow()
}