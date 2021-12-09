package com.poapm.alumno_app.data.dto

import com.poapm.alumno_app.domain.model.Class
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClassResponse(val result: List<Class>) {
}