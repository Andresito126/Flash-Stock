package com.jujus.flash_stock.features.auth.domain.entities

data class AuthUserEntity (
    val id: String,
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phone: String,
    val isActive: Boolean,
)