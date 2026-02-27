package com.jujus.flash_stock.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrapper(
    navGraphs : List<FeatureNavGraph>,
    startDestination: Any = LoginUser
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginUser
    ){
        navGraphs.forEach { graph ->
            graph.registerNavGraph(this, navController)
        }
    }
}