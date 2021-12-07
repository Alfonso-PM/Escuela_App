package com.poapm.alumno_app.presentation.login

import com.poapm.alumno_app.R
import com.poapm.alumno_app.core.exception.Failure

sealed class LoginFailure {
    object NotFound : Failure.FeatureFailure(R.string.notfound)
}