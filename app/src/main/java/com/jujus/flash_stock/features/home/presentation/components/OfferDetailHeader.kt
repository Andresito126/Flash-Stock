package com.jujus.flash_stock.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jujus.flash_stock.core.utils.StoreImageHelper


@Composable
fun OfferDetailHeader(
    photoUrl: String,
    onBackClick: () -> Unit,
    offerId: String,
) {
    Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            error = painterResource(StoreImageHelper.getDefaultStoreImage(offerId)),
            placeholder = painterResource(StoreImageHelper.getDefaultStoreImage(offerId)),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White, CircleShape)
                .size(40.dp)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Atrás", tint = Color.Black)
        }
    }
}