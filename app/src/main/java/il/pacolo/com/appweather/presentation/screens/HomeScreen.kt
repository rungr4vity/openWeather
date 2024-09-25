package il.pacolo.com.appweather.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import il.pacolo.com.appweather.R
import il.pacolo.com.appweather.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import il.pacolo.com.appweather.models.basic_weather
import il.pacolo.com.appweather.utils.Constants
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(viewModel:HomeViewModel = hiltViewModel()) {

    //var listado = viewModel.listado.value
    val listado: basic_weather by viewModel.listado.observeAsState(basic_weather("",0,""))

    var city = listado?.city ?: "No info"
    var date = LocalDate.now().dayOfMonth.toString() + "/" + LocalDate.now().monthValue + "/" + LocalDate.now().year
    var temperature = listado?.degrees.toString() ?: "No info"
    var weatherDescription = listado?.description ?: "No info"
    var icon = listado?.icon ?: "No info"

    //var city by remember { mutableStateOf(listado?.city ?: "Unknown") }  // Initial city
    //var date by remember { mutableStateOf("Sep 24, 2024") }
    //var temperature by remember { mutableStateOf("25") }
    //var weatherDescription by remember { mutableStateOf("Cloudy") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Search Bar
        SearchBar(
            cityName = city,
            onSearch = { newCity ->
                // Update the city name and trigger weather fetch for new city
                city = newCity
                // Logic to fetch new weather data can go here
                // For now, mock new data
                temperature = temperature
                weatherDescription = weatherDescription
            },viewModel
        )

        // City Name and Date
        CityAndDate(cityName = city, date = date.toString())

        // Current Temperature and Weather Icon
        CurrentWeatherSection(
            temperature = temperature,
            weatherDescription = weatherDescription,
            iconRes = icon

        )

        // Forecast Section (Optional)
        //ForecastSection()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}

@Composable
fun SearchBar(cityName: String, onSearch: (String) -> Unit,viewModel: HomeViewModel) {
    var searchText by remember { mutableStateOf(cityName) }

    Row(
        modifier = Modifier.fillMaxWidth().background(Color.LightGray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        // Search TextField
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Enter city") },
            modifier = Modifier
                .weight(1f)
                //.padding(end = 8.dp)
        )

        // Search Button
        Button(onClick = {
            //onSearch(searchText)
            viewModel.getWeather(searchText)

        }) {
            Text("Search")
        }
    }
}

@Composable
fun CityAndDate(cityName: String, date: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = cityName, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = date, fontSize = 16.sp, color = Color.Gray)
    }
}

@Composable
fun CurrentWeatherSection(temperature: String, weatherDescription: String, iconRes: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = temperature + "°F", fontSize = 48.sp, fontWeight = FontWeight.Bold)

        if (iconRes.isNotEmpty())
        {
            // Use Coil to load and display the weather icon
            AsyncImage(
                model = "https://openweathermap.org/img/wn/$iconRes@2x.png",
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.FillHeight
            )
        } else {
            Image(
            painter = painterResource(id = Constants.NULL_ICON),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.FillHeight
                )
        }

        Text(text = weatherDescription, fontSize = 20.sp, color = Color.Gray)
    }
}

@Composable
fun ForecastSection() {
    // This can be replaced with a list of forecast items.
    Text(text = "Weekly Forecast", fontSize = 20.sp, fontWeight = FontWeight.Medium)
    // Add more items here for the forecast list
}
