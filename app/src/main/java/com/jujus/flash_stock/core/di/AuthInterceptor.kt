package com.jujus.flash_stock.core.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import com.jujus.flash_stock.core.token.TokenManager
import kotlinx.coroutines.runBlocking


class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking { tokenManager.getToken() }
        val originalRequest = chain.request()
      //  //val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImJhMzI2NDg0LTM3MTYtNDJmMS05NDYzLWU0NGE3MmQ3N2QwYyIsInJvbGUiOiJzdG9yZSIsImlhdCI6MTc3MjE1Nzc4MiwiZXhwIjoxNzcyNzYyNTgyfQ.jlMxf3R3mwP3Cs7myKPuko0h97Sj7xib2QEvyzH984Q"

        val request = chain.request().newBuilder().apply {
            if (token != null) {
                header("Authorization", "Bearer $token")
            }
        }.build()

        return chain.proceed(request)
    }
}