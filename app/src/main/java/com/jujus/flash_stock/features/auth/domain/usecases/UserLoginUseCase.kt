package com.jujus.flash_stock.features.auth.domain.usecases

import com.jujus.flash_stock.features.auth.domain.entities.AuthToken
import com.jujus.flash_stock.features.auth.domain.repositories.AuthRepository
import javax.inject.Inject

class UserLoginUseCase @Inject constructor (
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<AuthToken> {
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(Exception("Email and password cannot be empty"))
        }
        return repository.loginUser(email, password)
    }
}