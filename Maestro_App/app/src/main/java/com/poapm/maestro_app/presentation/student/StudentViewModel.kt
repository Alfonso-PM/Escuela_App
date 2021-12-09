package com.poapm.maestro_app.presentation.student

import androidx.lifecycle.ViewModel
import com.poapm.maestro_app.core.presentation.BaseViewModel
import com.poapm.maestro_app.domain.usercase.GetAllClasses
import com.poapm.maestro_app.domain.usercase.GetDetailByIdClass
import com.poapm.maestro_app.presentation.materia.MateriaViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class StudentViewModel@Inject constructor(
    private val getDetailByIdClass: GetDetailByIdClass
) : BaseViewModel() {

    fun doGetDetailByIdClass(id: Int){
        getDetailByIdClass(id) {
            it.fold(::handleFailure) {
                state.value = StudentViewState.DetailReceived(it.result ?: listOf())

                true
            }
        }
    }

}