package com.poapm.alumno_app.presentation.login

import com.poapm.alumno_app.core.presentation.BaseViewState
import com.poapm.alumno_app.domain.model.Alumno

class LoginViewState : BaseViewState() {
    data class UserFound(val alumno: Alumno) : BaseViewState()
}