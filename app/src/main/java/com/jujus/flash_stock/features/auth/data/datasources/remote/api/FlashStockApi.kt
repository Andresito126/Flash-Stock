package com.jujus.flash_stock.features.auth.data.datasources.remote.api

import com.jujus.flash_stock.features.auth.data.datasources.remote.models.LoginUserRequest
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.LoginUserResponse
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserRequest
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserResponse
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.POST

interface FlashStockApi {
    @POST(value = "/api/auth/users/login")
    suspend fun loginUser(@Body request: LoginUserRequest): Response<LoginUserResponse>

    @POST(value = "/api/auth/users/register")
    suspend fun registerUser(@Body request: RegisterUserRequest): Response<RegisterUserResponse>
}