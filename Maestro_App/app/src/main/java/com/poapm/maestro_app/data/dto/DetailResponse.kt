package com.poapm.maestro_app.data.dto

import com.poapm.maestro_app.domain.model.DetailClass
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data  class DetailResponse (val result: List<DetailClass>? = listOf())