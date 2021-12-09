package com.poapm.maestro_app.domain.usercase

import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.data.dto.DetailResponse
import com.poapm.maestro_app.domain.repository.DetailRepository
import javax.inject.Inject

class GetDetailByIdClass @Inject constructor(private val detailRepository: DetailRepository) :
    UseCase<DetailResponse, Int>() {

    override suspend fun run(params: Int) = detailRepository.getDetailByIdClass(params)
}