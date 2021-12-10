package com.poapm.alumno_app.data.api

import com.poapm.alumno_app.data.dto.ClassDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClassDetailApi {
    @GET("cls/Class/std/{id}")
    fun getClassByIdAlumno(@Path("id") id: Int): Call<ClassDetailResponse>
}