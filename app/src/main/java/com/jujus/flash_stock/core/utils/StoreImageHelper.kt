package com.jujus.flash_stock.core.utils

import com.jujus.flash_stock.R
import kotlin.math.abs

object StoreImageHelper {
    fun getDefaultStoreImage(storeId: String?): Int {
        val images = listOf<Int>(
            R.drawable.store,
            R.drawable.store2
        )
        if (storeId == null) return images[0]
        val index = abs(storeId.hashCode()) % images.size
        return images[index]
    }
}