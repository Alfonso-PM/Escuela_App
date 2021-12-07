package com.poapm.maestro_app.presentation.login

import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.domain.model.Teacher



sealed class LoginViewState : BaseViewState() {

    data class UserFound(val teacher: Teacher) : BaseViewState()

}