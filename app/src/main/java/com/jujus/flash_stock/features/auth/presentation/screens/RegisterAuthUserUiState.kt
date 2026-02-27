package com.jujus.flash_stock.features.auth.presentation.screens

data class RegisterAuthUserUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val phone: String = "",
    val selectedRole: UserRole = UserRole.COMPRADOR,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRegisterSuccessful: Boolean = false
)

enum class UserRole { COMPRADOR, TIENDA }