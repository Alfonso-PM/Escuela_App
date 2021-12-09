package com.poapm.maestro_app.domain.usercase

import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.data.dto.ClassResponse
import com.poapm.maestro_app.domain.repository.ClassRepository
import javax.inject.Inject

class GetClassByIdTeacher @Inject constructor(private val classRepository: ClassRepository) :
    UseCase<ClassResponse, Int>() {

    override suspend fun run(params: Int) = classRepository.getClassByIdTeacher(params)
}