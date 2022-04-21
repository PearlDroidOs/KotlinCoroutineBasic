import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main () {
    runBlocking {
        launch(Dispatchers.Default) {
            //default context
            println("First context: $coroutineContext")
            withContext(Dispatchers.IO) {
                //IO context
                println("second context: $coroutineContext")
            }
            //back to default context
            println("third context: $coroutineContext")
        }
    }
}