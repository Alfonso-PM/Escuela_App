package com.poapm.alumno_app.presentation.login

import androidx.lifecycle.MutableLiveData
import com.poapm.alumno_app.core.presentation.BaseViewModel
import com.poapm.alumno_app.domain.model.Alumno
import com.poapm.alumno_app.domain.usecase.FindAlumno
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class LoginViewModel@Inject constructor(private val findAlumno: FindAlumno):
BaseViewModel(){
    var idalumno = MutableLiveData(0)
    val password = MutableLiveData("")

    fun doLogin() {
        findAlumno(Alumno(idStudent = idalumno.value?: 0, passwordStudent = password.value ?: "")) {
            it.fold(::handleFailure) {
                state.value = LoginViewState.UserFound(it)

                true
            }
        }

    }
}