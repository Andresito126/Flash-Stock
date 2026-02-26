package com.jujus.flash_stock.features.home.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.jujus.flash_stock.core.components.FlashBottomBar
import com.jujus.flash_stock.core.components.FlashHeader
import com.jujus.flash_stock.features.home.presentation.components.FlashOfferCard
import com.jujus.flash_stock.features.home.presentation.components.HomeCategoriesSection
import com.jujus.flash_stock.features.home.presentation.components.HomeOrangeHeader
import com.jujus.flash_stock.features.home.presentation.viewmodels.HomeViewModel
import com.jujus.flash_stock.features.store.presentation.viewmodels.StoreScreenViewModel

@Composable
fun HomeScreen(
    onOfferClick: (String) -> Unit,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()



    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { FlashHeader() },
        bottomBar = { FlashBottomBar(navController) },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item {
                HomeOrangeHeader()
            }

            item {
                HomeCategoriesSection()
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Ofertas en Vivo", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                    Text("VER TODO", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                }
            }

            item {
                FlowRow(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    maxItemsInEachRow = 2
                ) {
                    state.offers.forEach { offer ->
                        FlashOfferCard(
                            name = offer.name,
                            storeName = offer.storeName,
                            currentPrice = offer.currentPrice,
                            initialPrice = offer.initialPrice,
                            stock = offer.stock,
                            photoUrl = offer.photoUrl,
                            onNavigateToDetail = { onOfferClick(offer.id) }
                        )
                    }
                }
            }
        }
    }
}