package com.poapm.maestro_app.presentation.account

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.core.presentation.BaseViewModel
import com.poapm.maestro_app.domain.model.Teacher
import com.poapm.maestro_app.domain.usercase.DoLogout
import com.poapm.maestro_app.domain.usercase.GetAllTeachers
import com.poapm.maestro_app.domain.usercase.GetLocalTeachers
import com.poapm.maestro_app.domain.usercase.SaveTeacher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getLocalTeacher: GetLocalTeachers,
    private val doLogout: DoLogout,
    private val getAllTeachers: GetAllTeachers,
    private val saveTeacher: SaveTeacher
) :
    BaseViewModel() {

    fun getLocalTeacher() {
        getLocalTeacher(UseCase.None()) {
            it.fold(::teacherNotFound) { localUser ->
                setTeacherInfo(localUser)
            }
        }
    }

    fun doGetAllTeachers(name: String){
        getAllTeachers(name) {
            it.fold(::handleFailure) {
                state.value = AccountViewState.TeacherReceived(it.result ?: listOf())

                doSaveTeacher(it.result ?: listOf())
                true
            }
        }
    }


    private fun doSaveTeacher(teachers: List<Teacher>) {
        saveTeacher(teachers) {
            it.fold(::handleFailure) {
                it
            }
        }
    }

    fun doLogout() {
        doLogout(UseCase.None()) {
            it.fold(::handleFailure) {
                if (it) state.value = AccountViewState.UserNotFound
            }
        }
    }

    private fun teacherNotFound(failure: Failure) {
        state.value = AccountViewState.UserNotFound
        handleFailure(failure)
    }

    private fun setTeacherInfo(teacher: Teacher) {
        state.value = AccountViewState.LoggedUser(teacher)
    }


}