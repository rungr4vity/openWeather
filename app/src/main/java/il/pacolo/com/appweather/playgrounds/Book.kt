package il.pacolo.com.appweather.playgrounds


fun main() {


     val movies = mapOf<Int, String>(
          1 to "The Shawshank Redemption",
          2 to "The Godfather",
          3 to "The Godfather: Part II",
          4 to "The Dark Knight",
          5 to "12 Angry Men",
     )

    val listado = movies.values.toList()


    displayMovies(listado) { movies ->
        println(movies)
    }

}

fun displayMovies(listado: List<String>, onMovieSelected: (List<String>) -> Unit)  {
    onMovieSelected.invoke(listado)
}


// sealed class or sealed interface
class LiveFilm() {
}

class OfflineFilm() {
}




sealed interface FilmInterface {

    object LiveFilm: FilmInterface
    object OfflineFilm: FilmInterface


}