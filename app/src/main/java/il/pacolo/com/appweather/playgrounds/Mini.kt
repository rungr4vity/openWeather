package il.pacolo.com.appweather.playgrounds


data class Manga(val title:String, val volumes: Int)

val catalogue = listOf(
    Manga("Naruto", 72),
    Manga("Bleach", 176),
    Manga("One Piece", 1000),
    Manga("Dragon Ball", 73),
    Manga("Fairy Tail", 26),
    Manga("Fairy Tail", 20), // duplicate entry
    Manga("Chainsaw Man", 15),
    Manga("Chainsaw Man", 10), // duplicate entry
)


