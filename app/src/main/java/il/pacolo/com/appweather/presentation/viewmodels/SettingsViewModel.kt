package il.pacolo.com.appweather.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import il.pacolo.com.appweather.data.response.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


sealed interface MainViewState {
    object Loading: MainViewState
    data class Success(val items: List<String>): MainViewState
    data class Error(val message:String): MainViewState
}



class SettingsViewModel:ViewModel()  {

    private val _uiState = MutableStateFlow<MainViewState>(MainViewState.Loading)
    val uiState: StateFlow<MainViewState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try{
                _uiState.value = MainViewState.Success(listOf("1","2","3"))

            } catch (e: Exception) {
                _uiState.value = MainViewState.Error("Error loading data")
            }
        }
    }

}