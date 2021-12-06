package com.poapm.alumno_app.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poapm.alumno_app.core.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(private val myUser: MyUser):BaseViewModel() {

    val ussername= MutableLiveData("")
    val password= MutableLiveData("")

    fun Log(){
    myUser(Alumno(name=ussername.value?:"",password=password.value?:"")){
        it.fold(::handleFailure){
            state.value=LoginViewState.UserFound(it.alumno)


        true
            }
       }
    }
}