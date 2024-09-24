package il.pacolo.com.appweather.data

import il.pacolo.com.appweather.models.small
import javax.inject.Inject

class DataRepository @Inject constructor(val apiService: ApiService) {



    suspend fun getData(): Result<List<small>> {


        return try {
            val response = apiService.getLocation()
            //val data = response.map { converter(it)}

            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    fun converter(data: commentsResponseItem): small {
        return small(
            data.email,
            data.id
        )
    }


}