package com.poapm.alumno_app.data.api

import com.poapm.alumno_app.data.dto.ClassResponse
import retrofit2.Call
import retrofit2.http.GET

interface ClassApi {
    @GET("cls/Class")
    fun getAllClasses(): Call<ClassResponse>
}