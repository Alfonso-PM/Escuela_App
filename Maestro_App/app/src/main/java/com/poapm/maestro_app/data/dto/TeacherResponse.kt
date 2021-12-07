package com.poapm.maestro_app.data.dto
import com.poapm.maestro_app.domain.model.Teacher
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class TeacherResponse(val result: List<Teacher>? = listOf())