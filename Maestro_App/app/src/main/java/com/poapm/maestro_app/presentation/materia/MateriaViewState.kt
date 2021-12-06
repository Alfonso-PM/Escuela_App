package com.poapm.maestro_app.presentation.materia

import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.domain.model.Class

class MateriaViewState : BaseViewState() {

    data class MateriaReceived(val materia: List<Class>): BaseViewState()
}