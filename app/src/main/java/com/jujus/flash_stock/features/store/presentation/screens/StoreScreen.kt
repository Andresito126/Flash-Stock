package com.jujus.flash_stock.features.store.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.jujus.flash_stock.core.components.FlashBottomBar
import com.jujus.flash_stock.core.components.FlashHeader
import com.jujus.flash_stock.core.navigation.CreateOffer
import com.jujus.flash_stock.features.store.presentation.components.OfferCard
import com.jujus.flash_stock.features.store.presentation.components.StoreActionsSection
import com.jujus.flash_stock.features.store.presentation.components.StoreDashboardHeader
import com.jujus.flash_stock.features.store.presentation.viewmodels.StoreScreenViewModel

@Composable
fun StoreScreen(
    navController: NavHostController,
    viewModel: StoreScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadOffers()
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.dismissDeleteDialog() },
            title = { Text("¿Cancelar oferta?") },
            text = { Text("Esta acción cambiará el estado a CANCELLED en la base de datos.") },
            confirmButton = {
                TextButton(onClick = { viewModel.confirmDelete() }) {
                    Text("SÍ, CANCELAR", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(onClick = { viewModel.dismissDeleteDialog() }) {
                    Text("VOLVER")
                }
            }
        )
    }

    Scaffold(
        topBar = { FlashHeader() },
        bottomBar = { FlashBottomBar(navController) },
        containerColor = Color(0xFFF5F7FA)
    ) { paddingValues ->

        if (uiState.isLoading && uiState.offer.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color(0xFFFF5722))
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                StoreDashboardHeader()
            }

            item {
                StoreActionsSection(onCreateOfferClick = {
                    navController.navigate(CreateOffer)
                })
            }


            items(uiState.offer) { offer ->
                OfferCard(
                    id = offer.id,
                    title = offer.name,
                    status = offer.status,
                    stock = offer.stock,
                    price = offer.currentPrice.toString(),
                    url = offer.photoUrl ?: "https://via.placeholder.com/150",
                    timeClose = offer.endTime,
                    onDeleteClick = { id ->
                        viewModel.showConfirmDelete(id)
                    },
                    offerId = offer.id
                )
            }

            if (uiState.error != null) {
                item {
                    Text(
                        text = "Error: ${uiState.error}",
                        color = Color.Red,
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
        }
    }
}