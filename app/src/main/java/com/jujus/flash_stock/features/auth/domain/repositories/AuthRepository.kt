package com.jujus.flash_stock.features.auth.domain.repositories

import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserRequest
import com.jujus.flash_stock.features.auth.domain.entities.AuthToken
import com.jujus.flash_stock.features.auth.domain.entities.AuthUserEntity

interface AuthRepository {
    //USUARIO
    suspend fun loginUser(email: String, password: String): Result<AuthToken>
    suspend fun registerUser(user: RegisterUserRequest): Result<AuthUserEntity>
    //TIENDA

}