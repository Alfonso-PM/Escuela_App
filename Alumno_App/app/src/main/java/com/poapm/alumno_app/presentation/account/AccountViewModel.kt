package com.poapm.alumno_app.presentation.account

import androidx.lifecycle.ViewModel
import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.interactor.UseCase
import com.poapm.alumno_app.core.presentation.BaseViewModel
import com.poapm.alumno_app.domain.model.Alumno
import com.poapm.alumno_app.domain.usecase.DoLogout
import com.poapm.alumno_app.domain.usecase.GetAllAlumnos
import com.poapm.alumno_app.domain.usecase.GetAlumno
import com.poapm.alumno_app.domain.usecase.SaveAlumno
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getAlumno: GetAlumno,
    private val doLogout: DoLogout,
    private val getAllAlumnos: GetAllAlumnos,
    private val saveAlumno: SaveAlumno
):
BaseViewModel(){

    //CREAR FUNCION QUE TRAIGA LOS ALUMNOS (SE GAURDA EN LA BASE DE DATOS)

    fun getAlum(){
        getAlumno(UseCase.None()){}
    }

    fun getAllAlumn(name:String){
        getAllAlumnos(name){
            it.fold(::handleFailure){
                state.value = AccountViewState.AlumnoReceived(it.alumnos ?: listOf())

                saveAlumn(it.alumnos ?: listOf())
                true
            }
        }
    }

    private fun saveAlumn(alumnos: List<Alumno>) {
        saveAlumno(alumnos) {
            it.fold(::handleFailure) {
                it
            }
        }
    }

    fun doLogou() {
        doLogout(UseCase.None()) {
            it.fold(::handleFailure) {
                if (it) state.value = AccountViewState.UserNotFound
            }
        }
    }

    private fun alumnoNotFound(failure: Failure) {
        state.value = AccountViewState.UserNotFound
        handleFailure(failure)
    }

    private fun setAlumnoInfo(alumno: Alumno) {
        state.value = AccountViewState.LoggedUser(alumno)
    }

}