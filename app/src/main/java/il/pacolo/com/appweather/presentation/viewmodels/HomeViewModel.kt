package il.pacolo.com.appweather.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import il.pacolo.com.appweather.data.DataRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(dataRepository: DataRepository):ViewModel() {


    val data = dataRepository.getData()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home screen"
    }
    val text: LiveData<String> = _text




}