package com.poapm.alumno_app.presentation.materia

import com.poapm.alumno_app.core.presentation.BaseViewState
import com.poapm.alumno_app.domain.model.Class

class MateriaViewState : BaseViewState() {

    data class MateriaReceived(val materia: List<Class>): BaseViewState()
}