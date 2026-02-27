package com.jujus.flash_stock.features.auth.data.di

import com.jujus.flash_stock.core.di.AuthInterceptor
import com.jujus.flash_stock.core.di.FlashStockRetrofit
import com.jujus.flash_stock.features.auth.data.datasources.remote.api.FlashStockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthUserNetworkModule {

    @Provides
    @Singleton
    fun provideFlashStockApi(@FlashStockRetrofit retrofit: Retrofit): FlashStockApi {
        return retrofit.create(FlashStockApi::class.java)
    }
}