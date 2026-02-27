package com.jujus.flash_stock.features.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.jujus.flash_stock.core.navigation.FeatureNavGraph
import com.jujus.flash_stock.core.navigation.HomeRoute
import com.jujus.flash_stock.core.navigation.LoginStore
import com.jujus.flash_stock.core.navigation.LoginUser
import com.jujus.flash_stock.core.navigation.Offers
import com.jujus.flash_stock.core.navigation.RegisterUser
import com.jujus.flash_stock.features.auth.presentation.screens.LoginStoreScreen
import com.jujus.flash_stock.features.auth.presentation.screens.LoginUserScreen
import com.jujus.flash_stock.features.auth.presentation.screens.RegisterUserScreen

class AuthUserNavGraph: FeatureNavGraph {

    override fun registerNavGraph(navGraphBuilder: NavGraphBuilder, navController: NavHostController){

        navGraphBuilder.composable<LoginUser> {
            LoginUserScreen(
                onLoginSuccess = {
                    navController.navigate(HomeRoute) {
                        popUpTo<LoginUser> { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(RegisterUser)
                },
                onNavigateToStoreLogin = {
                    navController.navigate(LoginStore)
                },
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

        navGraphBuilder.composable<LoginStore> {
            LoginStoreScreen(
                onLoginSuccess = {
                    navController.navigate(Offers) {
                        popUpTo<LoginStore> { inclusive = true }
                    }
                },
                onNavigateToRegister = {  },
                onNavigateToUserLogin = {
                    navController.navigate(LoginUser) {
                        popUpTo<LoginStore> { inclusive = true }
                    }
                }
            )
        }
    }
}