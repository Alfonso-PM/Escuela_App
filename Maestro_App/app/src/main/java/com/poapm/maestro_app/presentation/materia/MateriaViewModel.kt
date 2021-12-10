package com.poapm.maestro_app.presentation.materia

import androidx.lifecycle.ViewModel
import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.core.presentation.BaseViewModel
import com.poapm.maestro_app.domain.model.Teacher
import com.poapm.maestro_app.domain.usercase.GetAllClasses
import com.poapm.maestro_app.domain.usercase.GetClassByIdTeacher
import com.poapm.maestro_app.domain.usercase.GetLocalTeachers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MateriaViewModel@Inject constructor(
    private val getAllClasses: GetAllClasses,
    private val getClassByIdTeacher: GetClassByIdTeacher
) : BaseViewModel() {


    fun doGetAllClasses(name: String){
        getAllClasses(name) {
            it.fold(::handleFailure) {
                state.value = MateriaViewState.MateriaReceived(it.result ?: listOf())

                true
            }
        }
    }


    fun doGetClassByIdTeacher(id: Int){
        getClassByIdTeacher(id) {
            it.fold(::handleFailure) {
                state.value = MateriaViewState.MateriaReceived(it.result ?: listOf())

                true
            }
        }
    }

    fun validate(tch:Teacher?){
        if(tch == null || tch.idTeacher <= 0){
            doGetAllClasses("")
        }else{
            doGetClassByIdTeacher(tch.idTeacher)
        }
    }
}