package com.jujus.flash_stock.features.store.data.di

import com.jujus.flash_stock.features.store.data.repositories.OffersRepositoryImpl
import com.jujus.flash_stock.features.store.domain.repositories.StoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StoreRepositoryModule {
    @Binds
    abstract fun bindStoreRepository(
        storeRepositoryImpl : OffersRepositoryImpl
    ): StoreRepository
}