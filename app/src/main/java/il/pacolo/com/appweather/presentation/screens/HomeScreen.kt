package il.pacolo.com.appweather.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import il.pacolo.com.appweather.R
import il.pacolo.com.appweather.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun WeatherScreen(viewModel:HomeViewModel = hiltViewModel()) {

    var listado by remember { mutableStateOf(viewModel.listado.value) }

    var city by remember { mutableStateOf(listado?.city ?: "Unknown") }  // Initial city
    var date by remember { mutableStateOf("Sep 24, 2024") }
    var temperature by remember { mutableStateOf("25") }
    var weatherDescription by remember { mutableStateOf("Cloudy") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
                temperature = "25°C"
                weatherDescription = "Partly Cloudy"
            }
        )

        // City Name and Date
        CityAndDate(cityName = city, date = date)

        // Current Temperature and Weather Icon
        CurrentWeatherSection(
            temperature = temperature,
            weatherDescription = weatherDescription,
            iconRes = R.drawable.ic_launcher_foreground // Replace with valid drawable resource
        )

        // Forecast Section (Optional)
        ForecastSection()
    }
}

@Composable
fun SearchBar(cityName: String, onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf(cityName) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Search TextField
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Enter city") },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )

        // Search Button
        Button(onClick = { onSearch(searchText) }) {
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
fun CurrentWeatherSection(temperature: String, weatherDescription: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = temperature, fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.FillHeight
        )
        Text(text = weatherDescription, fontSize = 20.sp, color = Color.Gray)
    }
}

@Composable
fun ForecastSection() {
    // This can be replaced with a list of forecast items.
    Text(text = "Weekly Forecast", fontSize = 20.sp, fontWeight = FontWeight.Medium)
    // Add more items here for the forecast list
}
