package com.poapm.maestro_app.domain.usercase

import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.domain.repository.TeacherRepository
import javax.inject.Inject

class DoLogout @Inject constructor(private val teacherRepository: TeacherRepository) :
    UseCase<Boolean, UseCase.None>() {

    override suspend fun run(params: None) = teacherRepository.doLogout()

}