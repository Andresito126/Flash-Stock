package com.jujus.flash_stock.features.auth.data.repositories

import com.jujus.flash_stock.core.token.TokenManager
import com.jujus.flash_stock.features.auth.data.datasources.remote.api.FlashStockApi
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.LoginUserRequest
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserRequest
import com.jujus.flash_stock.features.auth.domain.entities.AuthToken
import com.jujus.flash_stock.features.auth.domain.entities.AuthUserEntity
import com.jujus.flash_stock.features.auth.domain.repositories.AuthRepository
import com.jujus.flash_stock.features.auth.data.datasources.remote.mapper.toDomain
import javax.inject.Inject

class AuthUserRepositoryImpl @Inject constructor(
    private val api: FlashStockApi,
    private val tokenManager: TokenManager
): AuthRepository {
    override suspend fun loginUser(
        email: String,
        password: String
    ): Result<AuthToken> {

        return try {

            val response = api.loginUser(LoginUserRequest(email, password))

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {
                    val token = body.toDomain()
                    tokenManager.saveToken(token)
                    Result.success(token)
                } else {
                    Result.failure(Exception("Empty response body"))
                }

            } else {
                Result.failure(Exception("Login failed: ${response.code()}"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun registerUser(
        user: RegisterUserRequest
    ): Result<AuthUserEntity> {

        return try {

            val response = api.registerUser(user)

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {
                    Result.success(body.toDomain())
                } else {
                    Result.failure(Exception("Empty response body"))
                }

            } else {
                Result.failure(Exception("Register failed: ${response.code()}"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
