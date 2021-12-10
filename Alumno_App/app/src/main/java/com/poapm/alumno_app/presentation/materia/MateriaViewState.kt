package com.poapm.alumno_app.presentation.materia

import com.poapm.alumno_app.core.presentation.BaseViewState
import com.poapm.alumno_app.domain.model.Class
import com.poapm.alumno_app.domain.model.ClassDetail

class MateriaViewState : BaseViewState() {

    data class MateriaReceived(val materia: List<Class>): BaseViewState()

    data class DetailReceived(val detail: List<ClassDetail>): BaseViewState()
}