package com.jujus.flash_stock.features.store.presentation.screens

import com.jujus.flash_stock.core.navigation.Offers
import com.jujus.flash_stock.features.store.domain.entities.Offer

data class StoreUiState (
    val isLoading: Boolean = false,
    val offer: List<Offer> =emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false,
    val showDeleteDialog: Boolean = false,
    val selectedOfferId: String? = null
) {

}