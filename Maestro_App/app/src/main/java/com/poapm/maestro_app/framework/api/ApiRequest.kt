package com.poapm.maestro_app.framework.api

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.functional.Either
import com.poapm.maestro_app.core.plataform.NetworkHandler
import retrofit2.Call

interface ApiRequest {

    fun <T, R> makeRequest(
        networkHandler: NetworkHandler,
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return when (networkHandler.isConnected) {
            true -> {
                try {
                    val response = call.execute()
                    when (response.isSuccessful) {
                        true -> Either.Right(transform(response.body() ?: default))
                        false -> Either.Left(Failure.ServerError(500, ""))
                    }
                } catch (e: Exception) {
                    Either.Left(Failure.ServerError(500, e.message))
                }
            }
            false -> Either.Left(Failure.NetworkConnection)
        }
    }

}