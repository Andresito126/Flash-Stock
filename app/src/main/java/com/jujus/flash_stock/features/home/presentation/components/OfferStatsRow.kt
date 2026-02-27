package com.jujus.flash_stock.features.home.presentation.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OfferStatsRow(viewers: Int, timeLeft: String, stock: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StatItem(
            icon = Icons.Default.Groups,
            value = viewers.toString(),
            label = "VIENDO",
            containerColor = Color(0xFFE3F2FD),
            modifier = Modifier.weight(0.8f)
        )
        StatItem(
            icon = Icons.Default.Timer,
            value = timeLeft,
            label = "RESTANTE",
            containerColor = Color(0xFFFFF3E0),
            modifier = Modifier.weight(1.4f)
        )
        StatItem(
            icon = Icons.Default.FlashOn,
            value = stock.toString(),
            label = "STOCK ",
            containerColor = Color(0xFF1A237E),
            contentColor = Color.White,
            modifier = Modifier.weight(0.8f)
        )
    }
}