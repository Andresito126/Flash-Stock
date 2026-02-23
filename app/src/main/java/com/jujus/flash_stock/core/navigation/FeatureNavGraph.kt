package com.jujus.flash_stock.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface FeatureNavGraph {
    fun registerNavGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController
    )
}