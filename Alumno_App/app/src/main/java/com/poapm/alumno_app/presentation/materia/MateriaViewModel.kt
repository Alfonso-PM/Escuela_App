package com.poapm.alumno_app.presentation.materia

import androidx.lifecycle.ViewModel
import com.poapm.alumno_app.core.presentation.BaseViewModel
import com.poapm.alumno_app.domain.usecase.GetAllClasses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MateriaViewModel @Inject constructor(
    private val getAllClasses: GetAllClasses,
) : BaseViewModel() {

    fun doGetAllClasses(name: String){
        getAllClasses(name) {
            it.fold(::handleFailure) {
                state.value = MateriaViewState.MateriaReceived(it.result ?: listOf())

                true
            }
        }
    }
}