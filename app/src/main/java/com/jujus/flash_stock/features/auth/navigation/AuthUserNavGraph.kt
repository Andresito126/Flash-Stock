package com.jujus.flash_stock.features.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.jujus.flash_stock.core.navigation.FeatureNavGraph
import com.jujus.flash_stock.core.navigation.Home
import com.jujus.flash_stock.core.navigation.LoginUser
import com.jujus.flash_stock.core.navigation.Offers
import com.jujus.flash_stock.core.navigation.RegisterUser
import com.jujus.flash_stock.features.auth.presentation.screens.LoginUserScreen
import com.jujus.flash_stock.features.auth.presentation.screens.RegisterUserScreen

class AuthUserNavGraph: FeatureNavGraph {

    override fun registerNavGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController){

        navGraphBuilder.composable<LoginUser> {
            LoginUserScreen(
                onLoginSuccess = {
                    navController.navigate(Offers) {
                        popUpTo<LoginUser> { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(RegisterUser)
                }
            )
        }

        navGraphBuilder.composable<RegisterUser> {
            RegisterUserScreen(
                onRegisterSuccess = {
                    navController.navigate(Offers) {
                        popUpTo<RegisterUser> { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
    }
}