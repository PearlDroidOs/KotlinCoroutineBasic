import kotlinx.coroutines.*

fun main () {
    runBlocking {
        val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception Handled: ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from job")
            throw  IndexOutOfBoundsException("Exception a coroutine")
        }

        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw  ArithmeticException("Exception from async")
        }

        try {
            deferred.await()
        }catch (e: ArithmeticException) {
            println("Caught ArithmeticException ${e.message}")
        }
    }
}