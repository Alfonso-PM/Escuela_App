package com.poapm.maestro_app.data.source

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.functional.Either
import com.poapm.maestro_app.core.plataform.NetworkHandler
import com.poapm.maestro_app.data.api.ClassApi
import com.poapm.maestro_app.data.dto.ClassResponse
import com.poapm.maestro_app.domain.repository.ClassRepository
import com.poapm.maestro_app.framework.api.ApiRequest
import javax.inject.Inject

class ClassRepositoryImpl @Inject constructor(
    private val classApi: ClassApi,
    private val networkHandler: NetworkHandler
)  : ClassRepository, ApiRequest {


    override fun getAllClasses(): Either<Failure, ClassResponse> {
        val result = makeRequest(networkHandler, classApi.getAllClasses(), { it }, ClassResponse(emptyList()))

        return result
    }

    override fun getClassByIdTeacher(id: Int): Either<Failure, ClassResponse> {
        val result = makeRequest(networkHandler, classApi.getClassByIdTeacher(id), { it }, ClassResponse(emptyList()))

        return result
    }

}