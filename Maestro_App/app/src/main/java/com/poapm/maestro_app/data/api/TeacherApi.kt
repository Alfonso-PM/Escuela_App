package com.poapm.maestro_app.data.api

import com.poapm.maestro_app.data.dto.TeacherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TeacherApi {

    @GET("tch/Teacher/")
    fun getAllTeachers(): Call<TeacherResponse>
}