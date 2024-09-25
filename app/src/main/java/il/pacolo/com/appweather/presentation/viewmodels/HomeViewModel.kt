package il.pacolo.com.appweather.presentation.viewmodels

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.dataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import il.pacolo.com.appweather.data.DataRepository
import il.pacolo.com.appweather.models.basic_weather
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import il.pacolo.com.appweather.data.DataStoreManager
import il.pacolo.com.appweather.data.LOCATION_DATASTORE
import kotlinx.coroutines.flow.toList


@HiltViewModel
open class HomeViewModel @Inject constructor(private val dataRepository: DataRepository):ViewModel() {


    private val _listado = MutableLiveData<basic_weather>()
    val listado:LiveData<basic_weather> = _listado

    private val _lat = MutableLiveData<String>()
    val lat: LiveData<String> = _lat


    init {
        viewModelScope.launch {
//            dataRepository.getData("London").onSuccess {
//                _listado.value = it
//                println()
//            }




            //getWeatherLatLong(25.6667246,-100.2937433)
        }
    }

    fun getWeather(city: String){
        viewModelScope.launch {
            dataRepository.getData(city).onSuccess {
                _listado.value = it
                println()
            }
        }
    }

    fun getWeatherLatLong(lat:Double,lon:Double){

        viewModelScope.launch {
            dataRepository.getLocationLatLong(lat,lon).onSuccess {
                _listado.value = it
                println()
            }
        }
    }



}

