package com.poapm.maestro_app.domain.usercase

import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.domain.model.Teacher
import com.poapm.maestro_app.domain.repository.TeacherRepository
import javax.inject.Inject

class GetLocalTeachers @Inject constructor(private val teacherRepository: TeacherRepository) :
    UseCase<Teacher, UseCase.None>() {

    override suspend fun run(params: None) = teacherRepository.getLocalTeachers()

}