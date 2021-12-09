package com.poapm.maestro_app.data.source

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.functional.Either
import com.poapm.maestro_app.core.plataform.NetworkHandler
import com.poapm.maestro_app.data.api.DetailApi
import com.poapm.maestro_app.data.dto.DetailResponse
import com.poapm.maestro_app.domain.repository.DetailRepository
import com.poapm.maestro_app.framework.api.ApiRequest
import javax.inject.Inject

class DetailRepositoryImpl@Inject constructor(
    private val detailApi: DetailApi,
    private val networkHandler: NetworkHandler
)  : DetailRepository, ApiRequest {


    override fun getDetailByIdClass(id:Int): Either<Failure, DetailResponse> {
        val result = makeRequest(networkHandler, detailApi.getDetailByIdClass(id), { it }, DetailResponse(emptyList()))

        return result
    }
}