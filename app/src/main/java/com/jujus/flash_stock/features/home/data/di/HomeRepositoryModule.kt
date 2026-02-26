package com.jujus.flash_stock.features.home.data.di

import com.jujus.flash_stock.features.home.data.repositories.HomeRepositoryImpl
import com.jujus.flash_stock.features.home.domain.repositories.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}