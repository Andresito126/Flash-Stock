package com.jujus.flash_stock.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jujus.flash_stock.features.home.presentation.components.OfferDetailHeader
import com.jujus.flash_stock.features.home.presentation.components.OfferStatsRow
import com.jujus.flash_stock.features.home.presentation.components.OfferTitleSection

@Composable
fun PriceCard(
    initialPrice: Double,
    currentPrice: Double
) {
    val discountPercentage = if (initialPrice > 0) {
        ((initialPrice - currentPrice) / initialPrice * 100).toInt()
    } else 0

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F9FA)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "PRECIO INICIAL",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$${initialPrice}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = TextDecoration.LineThrough
                    ),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "PRECIO FLASH AHORA",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFFFF4500),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$${currentPrice}",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF1A237E)
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Surface(
                    color = Color(0xFFD1FFD7),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "AHORRAS ${discountPercentage}%",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        color = Color(0xFF1B5E20),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "*Baja cada rato!",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}