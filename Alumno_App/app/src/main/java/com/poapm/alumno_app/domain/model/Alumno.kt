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
    @PrimaryKey(autoGenerate = true)
    val idStudent: Int = 0,
    val nameStudent: String = "",
    val firstLastNameStudent: String = "",
    val secondLastNameStudent: String = "",
    val pictureStudent: String = "",
    var passwordStudent: String = "",
    var mailStudent: String = ""
): Parcelable{
}