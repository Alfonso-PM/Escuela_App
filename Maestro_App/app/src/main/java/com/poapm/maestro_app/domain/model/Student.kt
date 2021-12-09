package com.poapm.maestro_app.domain.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@Parcelize
@JsonClass(generateAdapter = true)
class Student (
    @PrimaryKey(autoGenerate = true)
    val idStudent: Int = 0,
    @Json(name = "nameStudent") val nameStudent: String = "",
    @Json(name = "firstLastNameStudent") val lastnameF: String = "",
    @Json(name = "secondLastNameStudent") val lastnameS: String = "",
    @Json(name = "pictureStudent") val urlStudent: String = "",
    @Json(name = "passwordStudent") var passwordStudent: String = "",
    @Json(name = "mailStudent") var mailStd: String = ""
): Parcelable {
}