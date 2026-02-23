package com.jujus.flash_stock.core.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.ui.graphics.vector.ImageVector
import com.jujus.flash_stock.core.navigation.Home
import com.jujus.flash_stock.core.navigation.Offers

sealed class BottomBarItem<T : Any>(
    val label: String,
    val icon: ImageVector,
    val route: T
) {
    object Explorar : BottomBarItem<Home>(
        label = "Explorar",
        icon = Icons.Default.Home,
        route = Home
    )
    object MiTienda : BottomBarItem<Offers>(
        label = "Mi Tienda",
        icon = Icons.Default.Storefront,
        route = Offers
    )

}