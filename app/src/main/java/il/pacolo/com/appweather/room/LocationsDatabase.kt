package il.pacolo.com.appweather.room

import androidx.room.Database
import androidx.room.RoomDatabase
import il.pacolo.com.appweather.models.LocationsEntity


@Database(entities = [LocationsEntity::class], version = 1, exportSchema = false)
abstract class LocationsDatabase: RoomDatabase() {

    abstract fun locationsDao(): LocationsDatabaseDao


}