package com.poapm.alumno_app.core.plataform

import android.content.Context
import android.content.SharedPreferences
import com.poapm.alumno_app.domain.model.Alumno
import com.squareup.moshi.Moshi
import javax.inject.Inject

class AuthenticationM @Inject constructor(private val context: Context){
    private val PREFS_KEY = "_CLASSPREFS"
    private val USER_KEY = "ALUMNO"

    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    private val moshi = Moshi.Builder().build()

    var alumno: Alumno?
        set(value) = preferences.edit()
            .putString(USER_KEY, moshi.adapter(Alumno::class.java).toJson(value)).apply()
        get() = preferences.getString(USER_KEY, null)?.let {
            return@let try {
                moshi.adapter(Alumno::class.java).fromJson(it)
            } catch (e: Exception) {
                null
            }
        }
}