package com.poapm.alumno_app.data.dto

import com.poapm.alumno_app.domain.model.Alumno
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlumnoResponse(val alumnos: List<Alumno>? = listOf())