package com.jujus.flash_stock.features.auth.data.di

import com.jujus.flash_stock.features.auth.data.repositories.AuthUserRepositoryImpl
import com.jujus.flash_stock.features.auth.domain.repositories.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AuthUserRepositoryModule {
    @Binds
    abstract fun bindAuthUserRepository(
        authUserRepositoryImpl : AuthUserRepositoryImpl
    ): AuthRepository

}