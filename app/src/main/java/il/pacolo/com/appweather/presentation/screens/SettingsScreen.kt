package il.pacolo.com.appweather.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import il.pacolo.com.appweather.presentation.viewmodels.SettingsViewModel



class HelloViewModel(): ViewModel() {

    private val _name = MutableLiveData("")
    val name : LiveData<String> = _name

    fun onNameChange(newName: String) {
        _name.value = newName
    }
}

@Composable
fun SettingsScreen() {

    val  viewModel: SettingsViewModel = viewModel()
    //val viewState: MainViewState

}


@Composable
fun HelloScreen(helloViewModel: HelloViewModel = viewModel()){
    val name by helloViewModel.name.observeAsState("")
    HelloContent(name = name, onNameChange = { helloViewModel.onNameChange(it) })
}


@Composable
fun HelloContent(name:String, onNameChange:(String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Hello, $name!",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = onNameChange,
            label = { Text(name) }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun HelloContentPreview() {
    HelloContent(name = "Frane",onNameChange = {})
}