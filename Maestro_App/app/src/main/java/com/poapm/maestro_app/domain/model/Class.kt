package com.poapm.maestro_app.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
class Class
    (val idClass: Int = 0,
     @Json(name = "nameClass") val nameCls: String = "",
     @Json(name = "descriptionClass") val description: String = "",
     @Json(name = "pictureClass") val url: String = "",
     @Json(name = "teacher") val teacher: Teacher = Teacher()
): Parcelable {
}