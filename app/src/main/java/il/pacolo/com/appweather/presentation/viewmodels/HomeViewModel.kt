package il.pacolo.com.appweather.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import il.pacolo.com.appweather.data.DataRepository
import il.pacolo.com.appweather.models.basic_weather
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel


@HiltViewModel
class HomeViewModel @Inject constructor(private val dataRepository: DataRepository):ViewModel() {

    private val _listado = MutableLiveData<basic_weather>()
    val listado:LiveData<basic_weather> = _listado


    init {
        viewModelScope.launch {
            dataRepository.getData().onSuccess {
                _listado.value = it
                println()
            }

        }
    }

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home screen"
//    }
//    val text: LiveData<String> = _text






}