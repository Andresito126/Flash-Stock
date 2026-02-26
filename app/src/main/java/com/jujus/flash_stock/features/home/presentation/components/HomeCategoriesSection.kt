package com.jujus.flash_stock.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeCategoriesSection() {
    val categories = listOf("TODOS", "PANADERÍA", "COMIDA", "FLORES", "PASTELES")

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories.size) { index ->
            val categoryName = categories[index]

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    modifier = Modifier.size(64.dp),
                    shape = RoundedCornerShape(16.dp),
                    color = if (index == 0) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.surface,
                    tonalElevation = 4.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        // Selección de iconos reales
                        val icon = when (categoryName) {
                            "TODOS" -> Icons.Default.AllInclusive
                            "PANADERÍA" -> Icons.Default.BakeryDining
                            "COMIDA" -> Icons.Default.Restaurant
                            "FLORES" -> Icons.Default.LocalFlorist
                            "PASTELES" -> Icons.Default.Cake
                            else -> Icons.Default.Category
                        }

                        Icon(
                            imageVector = icon,
                            contentDescription = categoryName,
                            tint = if (index == 0) Color.White else MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = categoryName,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = if (index == 0) MaterialTheme.colorScheme.onSurface else Color.Gray
                )
            }
        }
    }
}