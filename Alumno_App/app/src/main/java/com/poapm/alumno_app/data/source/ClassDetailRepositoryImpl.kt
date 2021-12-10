package com.poapm.alumno_app.data.source

import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.core.plataform.NetworkHandler
import com.poapm.alumno_app.data.api.ClassApi
import com.poapm.alumno_app.data.api.ClassDetailApi
import com.poapm.alumno_app.data.dto.ClassDetailResponse
import com.poapm.alumno_app.domain.repository.ClassDetailRepository
import com.poapm.alumno_app.framework.api.ApiRequest
import javax.inject.Inject

class ClassDetailRepositoryImpl @Inject constructor(
private val classDetailApi: ClassDetailApi,
private val networkHandler: NetworkHandler
)  : ClassDetailRepository, ApiRequest {
    override fun getClassByIdAlumno(id: Int): Either<Failure, ClassDetailResponse> {
        val result = makeRequest(networkHandler, classDetailApi.getClassByIdAlumno(id), { it }, ClassDetailResponse(emptyList()))

        return result
    }
}