package com.jujus.flash_stock.core.token

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.jujus.flash_stock.features.auth.domain.entities.AuthToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import android.util.Base64
import org.json.JSONObject

private val Context.dataStore by preferencesDataStore(name = "auth_prefs")

@Singleton
class TokenManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val TOKEN_KEY = stringPreferencesKey("jwt_token")

    suspend fun saveToken(token: AuthToken) {
        context.dataStore.edit { prefs ->
            // NO SE DEBE GUARADR EL TOKEN DIRECTSMENTE
            prefs[TOKEN_KEY] = token.value
        }
    }

    // Lee el token (el AuthInterceptor lo llama)
    suspend fun getToken(): String? {
        return context.dataStore.data
            .map { prefs -> prefs[TOKEN_KEY] }
            .firstOrNull()
    }

    suspend fun clearToken() {
        context.dataStore.edit { prefs ->
            prefs.remove(TOKEN_KEY)
        }
    }

    suspend fun getUserId(): String? {
        val token = getToken() ?: return null
        return try {
            val chunks = token.split(".")
            if (chunks.size < 2) return null

            // el payload
            val payload = String(Base64.decode(chunks[1], Base64.DEFAULT))
            val json = JSONObject(payload)

            json.getString("id")
        } catch (e: Exception) {
            null
        }
    }

}