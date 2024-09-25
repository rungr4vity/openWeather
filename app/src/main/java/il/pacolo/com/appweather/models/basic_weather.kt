package il.pacolo.com.appweather.models

data class basic_weather(

    val city: String,
    val degrees: Int,
    val description: String,
    val icon: String? = null,

)