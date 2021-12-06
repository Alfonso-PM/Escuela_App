package com.poapm.maestro_app.presentation.materia

import androidx.lifecycle.ViewModel
import com.poapm.maestro_app.core.presentation.BaseViewModel
import com.poapm.maestro_app.domain.usercase.GetAllClasses
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MateriaViewModel@Inject constructor(
    private val getAllClasses: GetAllClasses ,
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