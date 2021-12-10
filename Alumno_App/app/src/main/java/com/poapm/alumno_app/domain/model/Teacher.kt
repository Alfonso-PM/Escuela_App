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
class Teacher (
    @PrimaryKey(autoGenerate = true)
    val idTeacher: Int = 0,
    @Json(name = "nameTeacher") val name: String = "",
    @Json(name = "firstLastNameTeacher") val lastName1: String = "",
    @Json(name = "secondLastNameTeacher") val lastName2: String = "",
    @Json(name = "pictureTeacher") val url: String = "",
    @Json(name = "passwordTeacher") val password: String = "",
    @Json(name = "mailTeacher") val mail: String = "") : Parcelable {
}