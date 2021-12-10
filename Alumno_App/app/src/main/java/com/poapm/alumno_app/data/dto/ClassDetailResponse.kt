package com.poapm.alumno_app.data.dto

import com.poapm.alumno_app.domain.model.Class
import com.poapm.alumno_app.domain.model.ClassDetail
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ClassDetailResponse (val result: List<Class>? = listOf()) {
}