package com.jujus.flash_stock.core.di
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object FlashStockModule {
    @Provides
    @Singleton
    @FlashStockRetrofit
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://172.20.10.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}