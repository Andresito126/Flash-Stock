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

        val request = chain.request().newBuilder().apply {
            if (token != null) {
                header("Authorization", "Bearer $token")
            }
        }.build()

        return chain.proceed(request)
    }
}