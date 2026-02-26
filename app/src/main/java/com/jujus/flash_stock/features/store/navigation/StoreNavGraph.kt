package com.jujus.flash_stock.features.store.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.jujus.flash_stock.core.navigation.CreateOffer
import com.jujus.flash_stock.core.navigation.FeatureNavGraph
import com.jujus.flash_stock.core.navigation.Offers
import com.jujus.flash_stock.features.store.presentation.screens.CreateOfferScreen
import com.jujus.flash_stock.features.store.presentation.screens.StoreScreen


class StoreNavGraph: FeatureNavGraph {

    override fun registerNavGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController){

        navGraphBuilder.composable<Offers> {
            StoreScreen(navController = navController)
        }

        navGraphBuilder.composable<CreateOffer> {
            CreateOfferScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

    }

}
