package il.pacolo.com.appweather.data

import il.pacolo.com.appweather.data.response.weatherResponse
import il.pacolo.com.appweather.models.basic_weather
import il.pacolo.com.appweather.models.small
import javax.inject.Inject

class DataRepository @Inject constructor(val apiService: ApiService) {


    suspend fun getData(city:String): Result<basic_weather> {
        return try {
            val response = apiService.getLocation(city)
            val data = converter(response)
            Result.success(data)

        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    fun converter(data: weatherResponse): basic_weather {
        return basic_weather(
            data.name.toString(),
            data.main?.temp?.toInt() ?: 0,
            data.weather?.get(0)?.description.toString(),
            data.weather?.get(0)?.icon.toString()

        )
    }


}