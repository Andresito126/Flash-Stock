package com.jujus.flash_stock.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute
@Serializable
object Offers
@Serializable
object CreateOffer

@Serializable
object LoginUser

@Serializable
object RegisterUser


@Serializable
data class OfferDetailRoute(val offerId: String)