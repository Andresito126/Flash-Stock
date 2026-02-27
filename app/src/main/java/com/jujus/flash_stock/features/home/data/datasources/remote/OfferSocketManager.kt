package com.jujus.flash_stock.features.home.data.datasources.remote

import android.util.Log
import com.jujus.flash_stock.features.home.data.datasources.remote.models.OfferStateDto
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import org.json.JSONObject
import javax.inject.Inject

class OfferSocketManager @Inject constructor() {
    private var socket: Socket? = null

    fun connect() {
        socket = IO.socket("http://192.168.100.34:3000")
        socket?.connect()
    }

    // callbackFlow para convertir eventos de socket a kotlin flows


    fun observeOfferState(offerId: String, userId: String): Flow<OfferStateDto> = callbackFlow {
        val joinData = JSONObject().apply {
            put("offerId", offerId)
            put("userId", userId)
        }

        // le avisamos al servidor que nos unimos a la oferta
        socket?.emit("join_offer", joinData)

        val onOfferState = Emitter.Listener { args ->
            val data = args[0] as JSONObject
            Log.d("SOCKET_CHECK", "PRECIO RECIBIDO: ${data.getDouble("currentPrice")}")

            trySend(
                OfferStateDto(
                    offerId = data.getString("offerId"),
                    currentPrice = data.getDouble("currentPrice"),
                    stock = data.getInt("stock"),
                    status = data.getString("status"),
                    endsAt = data.optString("endsAt", ""),
                    startsAt = data.optString("startsAt", ""),
                    viewers = data.optInt("viewers", 0)
                )
            )
        }


        socket?.on("offer_state", onOfferState)


        awaitClose {
            Log.d("SOCKET_CHECK", "Cerrando conexión de oferta: $offerId")
            socket?.emit("leave_offer", JSONObject().put("offerId", offerId)) // Avisamos al server
            socket?.off(
                "offer_state",
                onOfferState
            )
        }
    }

}