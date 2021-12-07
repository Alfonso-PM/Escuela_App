package com.poapm.maestro_app.presentation.login

import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.exception.Failure

sealed class LoginFailure {

    object NotFound : Failure.FeatureFailure(R.string.not_found)

}