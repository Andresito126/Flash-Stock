package com.jujus.flash_stock.features.home.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.jujus.flash_stock.core.navigation.FeatureNavGraph
import com.jujus.flash_stock.core.navigation.HomeRoute
import com.jujus.flash_stock.core.navigation.OfferDetailRoute
import com.jujus.flash_stock.features.home.presentation.screens.HomeScreen

class HomeNavGraph : FeatureNavGraph {

    override fun registerNavGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController) {
        navGraphBuilder.apply {
            composable<HomeRoute> {
                HomeScreen(
                    navController = navController,
                    onOfferClick = { id ->
                        navController.navigate(OfferDetailRoute(offerId = id))
                    }
                )
            }


            composable<OfferDetailRoute> { backStackEntry ->
                val args: OfferDetailRoute = backStackEntry.toRoute()
            }
        }
    }
}