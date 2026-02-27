package com.jujus.flash_stock.features.auth.domain.repositories

import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterStoreRequest
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserRequest
import com.jujus.flash_stock.features.auth.domain.entities.AuthStoreEntity
import com.jujus.flash_stock.features.auth.domain.entities.AuthToken
import com.jujus.flash_stock.features.auth.domain.entities.AuthUserEntity

interface AuthRepository {
    //USUARIO
    suspend fun loginUser(email: String, password: String): Result<AuthToken>
    suspend fun registerUser(user: RegisterUserRequest): Result<AuthUserEntity>
    //
    suspend fun loginStore(email: String, password: String): Result<AuthToken>
    suspend fun registerStore(store: RegisterStoreRequest): Result<AuthStoreEntity>


}