package com.poapm.alumno_app.core.plataform

import android.content.Context
import com.poapm.alumno_app.core.extension.networkInfo
import javax.inject.Inject

class NetworkHandler @Inject constructor(private val context: Context) {

    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true

}