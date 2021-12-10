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
class ClassDetail (
    @PrimaryKey(autoGenerate = true)
    val idDetailClass: Int = 0,
    @Json(name = "grade1P") val p1: Int = 0,
    @Json(name = "grade2P") val p2: Int = 0,
    @Json(name = "grade3P") val p3: Int = 0,
    @Json(name = "student") val alumno: Alumno = Alumno(),
    @Json(name = "class") val objClass: Class = Class()
): Parcelable {
}