package com.poapm.alumno_app.presentation.materia

import androidx.lifecycle.ViewModel
import com.poapm.alumno_app.core.interactor.UseCase
import com.poapm.alumno_app.core.presentation.BaseViewModel
import com.poapm.alumno_app.domain.model.Alumno
import com.poapm.alumno_app.domain.usecase.GetAllClasses
import com.poapm.alumno_app.domain.usecase.GetClassByIdAlumno
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MateriaViewModel @Inject constructor(
    private val getAllClasses: GetAllClasses,
    private val getClassByIdAlumno: GetClassByIdAlumno
) : BaseViewModel() {

    fun doGetAllClasses(name: String) {
        getAllClasses(name) {
            it.fold(::handleFailure) {
                state.value = MateriaViewState.MateriaReceived(it.result ?: listOf())

                true
            }
        }
    }

    fun doGetClassByIdAlumno(id: Int) {
        getClassByIdAlumno(id) {
            it.fold(::handleFailure) {
                state.value = MateriaViewState.MateriaReceived(it.result ?: listOf())

                true
            }
        }
    }

    fun validate(std: Alumno?) {
        if (std == null || std.idStudent <= 0) {
            UseCase.None()
        } else {
            doGetAllClasses("")
        }
    }
}