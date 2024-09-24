package il.pacolo.com.appweather.data

import il.pacolo.com.appweather.data.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/character/")
    suspend fun getCharacters(@Query("page") page: Int): ResponseWrapper


}