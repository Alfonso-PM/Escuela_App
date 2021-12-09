package com.poapm.maestro_app.domain.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@Parcelize
@JsonClass(generateAdapter = true)
class DetailClass(
    @PrimaryKey(autoGenerate = true)
    val idDetailClass: Int = 0,
    @Json(name = "grade1P") val p1: Int = 0,
    @Json(name = "grade2P") val p2: Int = 0,
    @Json(name = "grade3P") val p3: Int = 0,
    @Json(name = "student") val student: Student = Student(),
    @Json(name = "class") val objClass: Class = Class()
): Parcelable {
}