package com.jujus.flash_stock.features.home.data.di

import android.content.Context
import androidx.room.Room
import com.jujus.flash_stock.core.di.FlashStockRetrofit
import com.jujus.flash_stock.features.home.data.datasources.local.HomeDatabase
import com.jujus.flash_stock.features.home.data.datasources.local.HomeOfferDao
import com.jujus.flash_stock.features.home.data.datasources.remote.api.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeDataModule {

    @Provides
    @Singleton
    fun provideHomeApi(@FlashStockRetrofit retrofit: Retrofit): HomeApi {
        return retrofit.create(HomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeDatabase(@ApplicationContext context: Context): HomeDatabase {
        return Room.databaseBuilder(context, HomeDatabase::class.java, "home.db").build()
    }

    @Provides
    fun provideHomeOfferDao(db: HomeDatabase): HomeOfferDao = db.homeOfferDao()
}