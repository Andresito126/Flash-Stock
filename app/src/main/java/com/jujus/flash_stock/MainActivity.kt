package com.jujus.flash_stock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jujus.flash_stock.core.navigation.NavigationWrapper
import com.jujus.flash_stock.core.ui.theme.Flash_stockTheme
import com.jujus.flash_stock.features.store.navigation.StoreNavGraph
import com.jujus.flash_stock.features.store.presentation.screens.StoreScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val navGraphs = listOf(
            StoreNavGraph(),
        )


        setContent {
            Flash_stockTheme {
                NavigationWrapper(navGraphs = navGraphs)            }
        }
    }
}