import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(2000)
        println("World !")
    }
    println("Hello")
    Thread.sleep(4000)
}