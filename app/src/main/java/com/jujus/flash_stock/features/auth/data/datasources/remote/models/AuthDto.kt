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


data class AuthStoreDto(
    @SerializedName("id") val id: String,
    //@SerializedName("owner_id") val ownerId: String,
    @SerializedName("store_name") val storeName: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("phone") val phone: String,
    //@SerializedName("address") val address: String,
    @SerializedName("city") val city: String,
    @SerializedName("is_active") val isActive: Boolean,
)

data class LoginStoreRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)

//STORE
data class LoginStoreResponse(
    val success: Boolean,
    val message: String,
    val data: LoginStoreData
)

data class LoginStoreData(
    val store: AuthStoreDto,
    val token: String
)

data class RegisterStoreRequest(
    @SerializedName("store_name") val storeName: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("phone") val phone: String,
    //@SerializedName("address") val address: String,
    @SerializedName("city") val city: String,
    @SerializedName("is_active") val isActive: Boolean,
)
data class RegisterStoreResponse(
    val success: Boolean,
    val message: String,
    val data: RegisterStoreData
)

data class RegisterStoreData(
    val store: AuthStoreDto,
    val token: String
)