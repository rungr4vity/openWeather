package il.pacolo.com.appweather.data

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import il.pacolo.com.appweather.models.LocationDetails
import kotlinx.coroutines.flow.map


const val LOCATION_DATASTORE = "location_details"
//val Context.preferencesDataStore: DataStore<Preferences> by preferencesDataStore(name = LOCATION_DATASTORE)
val Context.preferencesDataStore by preferencesDataStore(name = LOCATION_DATASTORE)



class DataStoreManager(private val context: Context) {


    companion object {

        val LATITUDE = stringPreferencesKey("latitude")
        val LONGITUDE = stringPreferencesKey("longitude")
        val CITY = stringPreferencesKey("city")
    }


    suspend fun saveToDataStore(locationDetails: LocationDetails) {
        context.preferencesDataStore.edit {
            it[LATITUDE] = locationDetails.lat.toString()
            it[LONGITUDE] = locationDetails.lon.toString()
            it[CITY] = locationDetails.city
        }
    }

    fun getFromDataStore() = context.preferencesDataStore.data.map {
        LocationDetails(
            city = it[CITY] ?: "",
            lat = it[LATITUDE]?.toDouble() ?: 0.0,
            lon = it[LONGITUDE]?.toDouble() ?: 0.0
        )
    }


    suspend fun clearDataStore() {
        context.preferencesDataStore.edit {
            it.clear()
        }

    }
}