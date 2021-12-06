package com.poapm.alumno_app.presentation.login

import com.poapm.alumno_app.core.presentation.BaseViewState

class LoginViewState  : BaseViewState() {

    data class UserFound(val alumno: Alumno) : BaseViewState()

}