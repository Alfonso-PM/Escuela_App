package com.poapm.maestro_app.presentation.account

import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.domain.model.Teacher


abstract class AccountViewState : BaseViewState() {

    data class LoggedUser(val teacher: Teacher) : BaseViewState()

    object UserNotFound : BaseViewState()

    data class TeacherReceived(val teacher: List<Teacher>): BaseViewState()

}