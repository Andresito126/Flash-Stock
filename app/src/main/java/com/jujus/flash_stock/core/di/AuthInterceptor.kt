package com.jujus.flash_stock.core.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImJhMzI2NDg0LTM3MTYtNDJmMS05NDYzLWU0NGE3MmQ3N2QwYyIsInJvbGUiOiJzdG9yZSIsImlhdCI6MTc3MjA4MjEwNiwiZXhwIjoxNzcyNjg2OTA2fQ.FgPr0IF4p8LLYFbrI4Al8wjLXrpWO83ZDxD0EqFz33U"

        val requestWithToken = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        return chain.proceed(requestWithToken)
    }
}