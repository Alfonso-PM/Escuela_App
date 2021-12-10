package com.poapm.maestro_app.data.api

import com.poapm.maestro_app.data.dto.DetailResponse
import com.poapm.maestro_app.domain.model.DetailClass
import retrofit2.Call
import retrofit2.http.*

interface DetailApi {

    @GET("cls/Class/cls/{id}")
    fun getDetailByIdClass(@Path("id") id: Int): Call<DetailResponse>

    @Headers("Content-Type: application/json")
    @PUT("detail/{id}")
    fun updateGrades(
        @Path("id") id: Int,
        @Body body:DetailClass
    ): Call<DetailResponse>
}