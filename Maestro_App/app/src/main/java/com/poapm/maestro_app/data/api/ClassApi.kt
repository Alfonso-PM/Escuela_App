package com.poapm.maestro_app.data.api

import com.poapm.maestro_app.data.dto.ClassResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClassApi {

    @GET("cls/Class")
    fun getAllClasses(): Call<ClassResponse>

    @GET("cls/Class/tch/{id}")
    fun getClassByIdTeacher(@Path("id") id: Int): Call<ClassResponse>
}