package com.jujus.flash_stock.features.auth.presentation.screens

import com.jujus.flash_stock.core.components.AuthRole

data class RegisterAuthUserUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val phone: String = "",
    val selectedRole: AuthRole = AuthRole.COMPRADOR,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRegisterSuccessful: Boolean = false
)

