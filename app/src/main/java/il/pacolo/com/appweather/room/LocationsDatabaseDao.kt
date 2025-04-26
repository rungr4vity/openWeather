package il.pacolo.com.appweather.room

import androidx.room.*
import il.pacolo.com.appweather.models.LocationsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface LocationsDatabaseDao {

    @Query("Select * from locations")
    fun getAllLocations(): Flow<List<LocationsEntity>>

    @Query("Select * from locations where id = :id")
    fun getLocationById(id:Long): Flow<LocationsEntity>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertLocation(valores: LocationsEntity)


//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun updateLocation(location:Locations)
//
//    @Query("DELETE from locations")
//    suspend fun deleteAllLocations()
//
//    @Query("DELETE from locations where id = :id")
//    suspend fun deleteLocationById(id:Long)

}