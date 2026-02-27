package com.jujus.flash_stock.features.store.data.datasources.remote.models

import com.google.gson.annotations.SerializedName

data class GenericResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: Any? = null
)