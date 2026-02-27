package com.jujus.flash_stock.features.auth.domain.entities

data class AuthStoreEntity (
    val id: String,
    //val ownerId: String,
    val storeName: String,
    val email: String,
    val password: String? = null,
    val phone: String,
    //val address: String,
    val city: String,
    val isActive: Boolean,
    //val isVerified: Boolean
)