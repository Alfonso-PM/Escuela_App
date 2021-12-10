package com.poapm.maestro_app.domain.repository

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.functional.Either
import com.poapm.maestro_app.data.dto.DetailResponse
import com.poapm.maestro_app.domain.model.DetailClass

interface DetailRepository {

    fun getDetailByIdClass(id:Int): Either<Failure, DetailResponse>

    fun updateGrades(id:Int, detail:DetailClass): Either<Failure, DetailResponse>

}