package com.poapm.maestro_app.domain.usercase

import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.data.dto.TeacherResponse
import com.poapm.maestro_app.domain.repository.TeacherRepository
import javax.inject.Inject

class GetAllTeachers @Inject constructor(private val teacherRepository: TeacherRepository) :
    UseCase<TeacherResponse, String>() {

    override suspend fun run(params: String) = teacherRepository.getAllTeachers()
}