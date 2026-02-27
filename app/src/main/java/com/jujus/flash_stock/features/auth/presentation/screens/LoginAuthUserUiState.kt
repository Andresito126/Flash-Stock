package com.jujus.flash_stock.features.auth.presentation.screens

import com.jujus.flash_stock.features.auth.domain.entities.AuthUserEntity


data class LoginAuthUserUiState (
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoginSuccessful: Boolean = false
)