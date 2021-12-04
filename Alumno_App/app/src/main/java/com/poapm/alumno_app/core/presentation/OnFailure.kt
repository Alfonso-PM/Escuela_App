package com.poapm.alumno_app.core.presentation

import com.poapm.alumno_app.core.exception.Failure

interface OnFailure {

    fun handleFailure(failure: Failure?)

}