package il.pacolo.com.appweather.playgrounds


// Playgrounds for practicing Kotlin

fun main() {

    val list:Response = Response(1,"name",true,"image","lastName")
    val list2:Response = Response(2,"name2",true,"image2","lastName2")
    val listado = listOf(list,list2)
    val resultado: List<small_response> = listado.map {
        small_response(it.name,it.id)
    }

    println(resultado)


}

data class Response(
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val image: String,
    val lastName: String
)

data class small_response(
    val email: String,
    val id: Int
)