package com.jujus.flash_stock.features.auth.data.datasources.remote.models

import com.google.gson.annotations.SerializedName

data class AuthUserDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("phone") val phone: String,
    @SerializedName("is_active") val isActive: Boolean,
)

data class LoginUserRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)
data class LoginUserResponse(
    val success: Boolean,
    val message: String,
    val data: LoginUserData
)

data class LoginUserData(
    val user: AuthUserDto,
    val token: String
)

data class RegisterUserRequest(
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("phone") val phone: String,
    @SerializedName("is_active") val isActive: Boolean,
)
data class RegisterUserResponse(
    val success: Boolean,
    val message: String,
    val data: RegisterUserData
)

data class RegisterUserData(
    val user: AuthUserDto,
    val token: String
)