package com.jujus.flash_stock.core.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjJkNjRkOGJmLWE0OTQtNDkyOC04ZTNjLTM1ODMzZWMwOTdmMiIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzcyMTEyNjI4LCJleHAiOjE3NzI3MTc0Mjh9.pqoRfjECTKHzNGAt_cEQWDqi4ReJusrqEJk6QvElrZ8"

        val requestWithToken = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        return chain.proceed(requestWithToken)
    }
}