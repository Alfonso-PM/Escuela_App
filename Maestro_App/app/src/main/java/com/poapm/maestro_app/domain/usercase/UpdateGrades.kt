package com.poapm.maestro_app.domain.usercase

import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.data.dto.DetailResponse
import com.poapm.maestro_app.domain.model.DetailClass
import com.poapm.maestro_app.domain.repository.DetailRepository
import javax.inject.Inject

class UpdateGrades @Inject constructor(private val detailRepository: DetailRepository) :
    UseCase<DetailResponse, DetailClass>() {

    override suspend fun run(params: DetailClass) = detailRepository.updateGrades(params.idDetailClass,params)

    }