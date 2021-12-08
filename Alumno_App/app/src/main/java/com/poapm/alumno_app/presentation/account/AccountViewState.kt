package com.poapm.alumno_app.presentation.account

import com.poapm.alumno_app.core.presentation.BaseViewModel
import com.poapm.alumno_app.core.presentation.BaseViewState
import com.poapm.alumno_app.domain.model.Alumno

class AccountViewState : BaseViewModel(){
    data class LoggedUser(val alumno: Alumno) : BaseViewState()

    object UserNotFound : BaseViewState()

    data class AlumnoReceived(val alumno: List<Alumno>): BaseViewState()
}