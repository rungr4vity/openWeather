package il.pacolo.com.appweather.data

import il.pacolo.com.appweather.data.response.weatherResponse
import il.pacolo.com.appweather.models.basic_weather
import il.pacolo.com.appweather.models.small
import javax.inject.Inject

class DataRepository @Inject constructor(val apiService: ApiService) {
    suspend fun getData(): Result<basic_weather> {
        return try {
            val response = apiService.getLocation()
            val data = converter(response)
            //val data = response.map { converter(it)}

            Result.success(data)

        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    fun converter(data: weatherResponse): basic_weather {
        return basic_weather(
            data.name.toString(),
            data.main?.temp ?: 0.00,
            data.weather?.get(0)?.description.toString()
        )
    }


}