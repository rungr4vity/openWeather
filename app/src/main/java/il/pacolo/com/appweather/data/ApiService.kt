package il.pacolo.com.appweather.data

import il.pacolo.com.appweather.data.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    @GET("/api/character/")
//    suspend fun getCharacters(@Query("page") page: Int): ResponseWrapper


    @GET("/weather?q=London&appid=97fb0baad55faa308a3ff5ccc0a2d19e")
    suspend fun getLocation(): ResponseWrapper


}