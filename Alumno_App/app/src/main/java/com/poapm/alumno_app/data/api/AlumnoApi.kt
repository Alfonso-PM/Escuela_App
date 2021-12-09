package com.poapm.alumno_app.data.api

import com.poapm.alumno_app.data.dto.AlumnoResponse
import retrofit2.Call
import retrofit2.http.GET

interface AlumnoApi {
    @GET("std/Student")
    fun getAllAlumnos(): Call<AlumnoResponse>
}