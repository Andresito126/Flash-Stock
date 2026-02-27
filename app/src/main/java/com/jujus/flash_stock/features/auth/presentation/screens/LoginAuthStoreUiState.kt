package com.jujus.flash_stock.features.auth.presentation.screens

import com.jujus.flash_stock.core.components.AuthRole

data class LoginAuthStoreUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoginSuccessful: Boolean = false,
    val selectedRole: AuthRole = AuthRole.TIENDA,

    )
