package il.pacolo.com.appweather.presentation.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun GeneralScreen() {

    val estado  = mutableStateOf("")

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {

        TextField(
            value = estado.value,
            onValueChange = {},
            
        )
    }

}



@Preview(showBackground = true,device = Devices.PIXEL_4)
@Composable
fun GeneralScreenPreview(){
    GeneralScreen()
}


