package com.jujus.flash_stock.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jujus.flash_stock.features.home.presentation.components.OfferDetailHeader
import com.jujus.flash_stock.features.home.presentation.components.OfferStatsRow
import com.jujus.flash_stock.features.home.presentation.components.OfferTitleSection
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jujus.flash_stock.features.home.presentation.components.PriceCard
import com.jujus.flash_stock.features.home.presentation.viewmodels.OfferDetailViewModel

@Composable
fun OfferDetailScreen(
    offerId: String,
    onBackClick: () -> Unit,
    viewModel: OfferDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(offerId) {
        viewModel.loadOffer(offerId)
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column (modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            OfferDetailHeader(state.photoUrl, onBackClick, offerId = offerId,)

            Surface(
                modifier = Modifier.offset(y = (-20).dp),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                color = Color.White
            ) {
                Column {
                    OfferTitleSection(state.offerName)
                    OfferStatsRow(state.viewers, state.timeLeft, state.stock)

                    Text(
                        "DESCRIPCIÓN",
                        modifier = Modifier.padding(start = 16.dp, top = 24.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        state.description,
                        modifier = Modifier.padding(16.dp),
                        color = Color.Gray
                    )

                    PriceCard(state.initialPrice, state.currentPrice)
                    Spacer(Modifier.height(100.dp))
                }
            }
        }

        Button(
            onClick = {  },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF4500)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("COMPRAR AHORA", fontWeight = FontWeight.Bold)
        }
    }
}