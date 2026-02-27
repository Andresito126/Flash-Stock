package com.jujus.flash_stock.core.utils

import com.jujus.flash_stock.R
import kotlin.math.abs

object OfferImageHelper {

    fun getDefaultImage(offerId: String?): Int {
        val images = listOf<Int>(
            R.drawable.defau,
            R.drawable.dafault2,
            R.drawable.default3
        )

        if (offerId == null) return images[0]

        // Math.abs por si el hash sale negativo, para que no truene el index
        val index = abs(offerId.hashCode()) % images.size
        return images[index]
    }
}