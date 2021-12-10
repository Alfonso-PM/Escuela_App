package com.poapm.maestro_app.presentation.studentDetail

import androidx.lifecycle.ViewModel
import com.poapm.maestro_app.core.presentation.BaseViewModel
import com.poapm.maestro_app.domain.model.DetailClass
import com.poapm.maestro_app.domain.usercase.UpdateGrades
import com.poapm.maestro_app.presentation.materia.MateriaViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class StudentDetailViewModel @Inject constructor(
    private val updateGrades: UpdateGrades
) : BaseViewModel() {

    fun doUpdateGrades(detail: DetailClass){
        updateGrades(detail) {
            it.fold(::handleFailure) {

                true
            }
        }
    }

}