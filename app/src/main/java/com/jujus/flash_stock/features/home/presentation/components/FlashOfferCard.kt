package com.jujus.flash_stock.features.home.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun FlashOfferCard(
    name: String,
    storeName: String,
    currentPrice: Double,
    initialPrice: Double,
    stock: Int,
    photoUrl: String?,
    onNavigateToDetail: () -> Unit
) {
    ElevatedCard(
        onClick = onNavigateToDetail,
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column {
            Box(modifier = Modifier.height(140.dp).fillMaxWidth()) {

                AsyncImage(
                    model = photoUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Badge Naranja "FLASH"
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(bottomEnd = 12.dp)
                ) {
                    Row(Modifier.padding(horizontal = 8.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.FlashOn, null, tint = Color.White, modifier = Modifier.size(12.dp))
                        Text("FLASH", color = Color.White, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
                    }
                }

                if (stock <= 2) {
                    Surface(
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.TopEnd).padding(8.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("STOCK CRÍTICO", color = Color.White, modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.labelSmall)
                    }
                }
            }

            Column(Modifier.padding(12.dp)) {
                Text(storeName.uppercase(), style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                Text(name, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("$${currentPrice}", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black)
                    Spacer(Modifier.width(4.dp))
                    Text("$${initialPrice}", style = MaterialTheme.typography.bodySmall, textDecoration = TextDecoration.LineThrough, color = Color.Gray)
                }

                Text(
                    text = "Quedan $stock piezas",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = if (stock <= 2) Color.Red else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}