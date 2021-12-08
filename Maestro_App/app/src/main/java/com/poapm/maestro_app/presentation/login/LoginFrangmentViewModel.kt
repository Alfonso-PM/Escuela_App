package com.poapm.maestro_app.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poapm.maestro_app.core.presentation.BaseViewModel
import com.poapm.maestro_app.domain.model.Teacher
import com.poapm.maestro_app.domain.usercase.FindTeacher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class LoginFrangmentViewModel @Inject constructor(private val findTeacher: FindTeacher) : BaseViewModel() {

    var idteacher = MutableLiveData(0)
    val password = MutableLiveData("")

    fun doLogin() {
        findTeacher(Teacher(idTeacher = idteacher.value?: 0, password = password.value ?: "")) {
            it.fold(::handleFailure) {
                state.value = LoginViewState.UserFound(it)

                true
            }
        }

    }

}