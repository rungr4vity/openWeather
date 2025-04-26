package il.pacolo.com.appweather.playgrounds

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {


    runBlocking {

        val windows = async(Dispatchers.IO) { println("First dispatcher") }
        val doors = async(Dispatchers.Default) { println("Second dispatcher") }

        launch(Dispatchers.Default) {

            println("Inside the launch")
        }
    }

}


