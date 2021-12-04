package com.poapm.maestro_app.core.presentation

import com.poapm.maestro_app.core.exception.Failure

interface OnFailure {

    fun handleFailure(failure: Failure?)

}