package com.jujus.flash_stock.features.home.domain.usecases

import com.jujus.flash_stock.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

// es el que se dispara cuando se entra a home o se hace el pull to refresh
class RefreshHomeOffersUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(categoryId: String? = null): Result<Unit> {
        return repository.fetchActiveOffers(categoryId = categoryId)
    }
}