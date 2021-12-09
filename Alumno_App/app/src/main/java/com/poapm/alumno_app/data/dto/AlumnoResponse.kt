package com.poapm.alumno_app.data.dto

import com.poapm.alumno_app.domain.model.Alumno
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AlumnoResponse(val result: List<Alumno>? = listOf())