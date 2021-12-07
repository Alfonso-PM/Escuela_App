package com.poapm.maestro_app.core.plataform

import android.content.Context
import android.content.SharedPreferences
import com.poapm.maestro_app.domain.model.Teacher
import com.squareup.moshi.Moshi
import javax.inject.Inject

class AuthManager @Inject constructor(private val context: Context) {

    private val PREFS_KEY = "CLASS_PREFS"
    private val USER_KEY = "TEACHER"

    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    private val moshi = Moshi.Builder().build()

    var teacher: Teacher?
        set(value) = preferences.edit()
            .putString(USER_KEY, moshi.adapter(Teacher::class.java).toJson(value)).apply()
        get() = preferences.getString(USER_KEY, null)?.let {
            return@let try {
                moshi.adapter(Teacher::class.java).fromJson(it)
            } catch (e: Exception) {
                null
            }
        }

}