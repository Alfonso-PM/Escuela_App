package com.poapm.maestro_app.data.api

import com.poapm.maestro_app.data.dto.DetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailApi {

    @GET("cls/Class/cls/{id}")
    fun getDetailByIdClass(@Path("id") id: Int): Call<DetailResponse>

}