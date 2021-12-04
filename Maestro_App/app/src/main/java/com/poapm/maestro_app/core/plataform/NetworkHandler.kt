package com.poapm.maestro_app.core.plataform

import android.content.Context
import com.poapm.maestro_app.core.extension.networkInfo
import javax.inject.Inject

class NetworkHandler @Inject constructor(private val context: Context) {

    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true

}