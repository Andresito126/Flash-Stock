package com.jujus.flash_stock.features.auth.domain.usecases

import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserRequest
import com.jujus.flash_stock.features.auth.domain.entities.AuthUserEntity
import com.jujus.flash_stock.features.auth.domain.repositories.AuthRepository
import javax.inject.Inject

class UserRegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(user: RegisterUserRequest): Result<AuthUserEntity> {
        return if (user.email.isEmpty()) {
            Result.failure(IllegalArgumentException("Email is required"))
        } else {
            repository.registerUser(user)
        }
    }
}