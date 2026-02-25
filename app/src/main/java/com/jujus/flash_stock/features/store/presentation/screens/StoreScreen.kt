package com.jujus.flash_stock.features.store.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.jujus.flash_stock.core.components.FlashBottomBar
import com.jujus.flash_stock.core.components.FlashHeader
import com.jujus.flash_stock.features.store.presentation.components.OfferCard
import com.jujus.flash_stock.features.store.presentation.components.StoreActionsSection
import com.jujus.flash_stock.features.store.presentation.components.StoreDashboardHeader

@Composable
fun StoreScreen() {
    Scaffold(
        topBar = { FlashHeader() },
        bottomBar = {  },
        containerColor = Color(0xFFF5F7FA)
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                StoreDashboardHeader()
            }

            item {
                StoreActionsSection()
            }

            items(5) {
                OfferCard(
                    title = "Pack de Baguettes (3x)",
                    price = "105",
                    stock = 5
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun oesadjsk(){
    StoreScreen()
}