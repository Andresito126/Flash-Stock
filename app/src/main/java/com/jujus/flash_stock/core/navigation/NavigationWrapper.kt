package com.jujus.flash_stock.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrapper(
    navGraphs : List<FeatureNavGraph>
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Offers
    ){
        navGraphs.forEach { graph ->
            graph.registerNavGraph(this, navController)
        }
    }
}