package com.poapm.maestro_app.core.interactor

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.functional.Either
import kotlinx.coroutines.*

abstract class UseCase <out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    @DelicateCoroutinesApi
    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        val job = GlobalScope.async(Dispatchers.IO) { run(params) }
        GlobalScope.launch(Dispatchers.Main) { onResult(job.await()) }
    }

    class None
}