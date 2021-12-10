package com.poapm.alumno_app.domain.usecase

import com.poapm.alumno_app.core.interactor.UseCase
import com.poapm.alumno_app.data.dto.ClassDetailResponse
import com.poapm.alumno_app.data.dto.ClassResponse
import com.poapm.alumno_app.domain.repository.ClassDetailRepository
import com.poapm.alumno_app.domain.repository.ClassRepository
import javax.inject.Inject

class GetClassByIdAlumno @Inject constructor(private val classDetailRepository: ClassDetailRepository) :
    UseCase<ClassDetailResponse, Int>() {

    override suspend fun run(params: Int) = classDetailRepository.getClassByIdAlumno(params)
}