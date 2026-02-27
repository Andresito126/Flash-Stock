package com.jujus.flash_stock.core.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImJhMzI2NDg0LTM3MTYtNDJmMS05NDYzLWU0NGE3MmQ3N2QwYyIsInJvbGUiOiJzdG9yZSIsImlhdCI6MTc3MjE1Nzc4MiwiZXhwIjoxNzcyNzYyNTgyfQ.jlMxf3R3mwP3Cs7myKPuko0h97Sj7xib2QEvyzH984Q"

        val requestWithToken = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        return chain.proceed(requestWithToken)
    }
}