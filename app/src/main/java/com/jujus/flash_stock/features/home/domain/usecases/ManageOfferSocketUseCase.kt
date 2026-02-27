package com.jujus.flash_stock.features.home.domain.usecases

import com.jujus.flash_stock.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class ManageOfferSocketUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend fun connect(id: String) = repository.listenToOfferUpdates(id)
    suspend fun disconnect(id: String) = repository.leaveOfferUpdates(id)
}