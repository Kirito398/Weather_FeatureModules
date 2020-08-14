package ru.biozzlab.entities

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params, out Failure> {
    private val ioContext = Dispatchers.IO
    private val mainContext = Dispatchers.Main
    private var job = Job()

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        unsubscribe()
        job = Job()

        CoroutineScope(mainContext + job).launch {
            val result = withContext(ioContext) {
                run(params)
            }

            onResult(result)
        }
    }

    fun unsubscribe() {
        job.apply {
            cancelChildren()
            cancel()
        }
    }
}