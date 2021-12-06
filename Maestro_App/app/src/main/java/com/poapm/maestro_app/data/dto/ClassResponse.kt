package com.poapm.maestro_app.data.dto

import com.poapm.maestro_app.domain.model.Class
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClassResponse(val result: List<Class>? = listOf())
