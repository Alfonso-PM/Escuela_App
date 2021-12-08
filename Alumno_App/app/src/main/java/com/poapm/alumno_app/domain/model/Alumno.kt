package com.poapm.alumno_app.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
class Alumno(
    @PrimaryKey(autoGenerate = false)
    val idStudent: Int = 0,
    @Json(name = "nameStudent") val name: String = "",
    @Json(name = "firstLastNameStudent") val paterno: String = "",
    @Json(name = "secondLastNameStudent") val materno: String = "",
    @Json(name = "pictureStudent") val urlThumb: String = "",
    @Json(name = "grade1P") val p1: Int = 0,
    @Json(name = "grade2P") val p2: Int = 0,
    @Json(name = "grade3P") val p3: Int = 0,
    @Json(name = "passwordStudent") var password: String = "",
    @Json(name = "mailStudent") var mail: String = ""
): Parcelable{
}