package com.poapm.alumno_app.domain.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
@JsonClass(generateAdapter = true)
class Class (val idClass: Int = 0,
             val nameClass: String = "",
             val descriptionClass: String = "",
             val pictureClass: String = "",
             val alumno: Alumno = Alumno()
): Parcelable {
}