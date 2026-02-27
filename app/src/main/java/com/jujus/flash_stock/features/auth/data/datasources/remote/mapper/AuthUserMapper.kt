package com.jujus.flash_stock.features.auth.data.datasources.remote.mapper

import com.jujus.flash_stock.features.auth.data.datasources.remote.models.AuthStoreDto
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.AuthUserDto
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.LoginStoreResponse
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.LoginUserRequest
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.LoginUserResponse
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterStoreResponse
import com.jujus.flash_stock.features.auth.data.datasources.remote.models.RegisterUserResponse
import com.jujus.flash_stock.features.auth.domain.entities.AuthStoreEntity
import com.jujus.flash_stock.features.auth.domain.entities.AuthUserEntity
import com.jujus.flash_stock.features.auth.domain.entities.AuthToken
fun AuthUserDto.toDomain(): AuthUserEntity {
    return AuthUserEntity(
        id = id,
        name = name,
        lastName = lastName,
        email = email,
        password = password,
        isActive = isActive,
        phone = phone
    )
}
fun LoginUserResponse.toDomain() = AuthToken(value = this.data.token)

fun RegisterUserResponse.toDomain() = this.data.user.toDomain()

fun AuthStoreDto.toDomain(): AuthStoreEntity {
    return AuthStoreEntity(
        id = id,
        storeName = storeName,
        email = email,
        password = password,
        phone = phone,
        city = city,
        isActive = isActive
    )
}

fun LoginStoreResponse.toDomain() = AuthToken(value = this.data.token)

fun RegisterStoreResponse.toDomain() = this.data.store.toDomain()