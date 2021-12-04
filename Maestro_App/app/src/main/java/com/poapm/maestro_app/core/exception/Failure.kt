package com.poapm.maestro_app.core.exception
import androidx.annotation.StringRes
import com.poapm.maestro_app.core.exception.Failure.FeatureFailure

sealed class Failure : Throwable() {
    data class ServerError(val code: Int, val serverMessage: String?, val payload: String? = null) :
        Failure()

    object NetworkConnection : Failure()
    object DatabaseError : Failure()
    object Unauthorized : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure(@StringRes val defaultMessage: Int? = null) : Failure()
}