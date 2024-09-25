# openWeather
Weather App is the application of science and technology to predict the conditions of the atmosphere for a given location and time.


I used and deployed my app on Samsung Galaxy with Android 14
Android Studio Koala

i used MVVM and basic clean arch for maintenance,support and separation of concerns
    - Data layer (API Service and Repository) we can switch for offline data or live data just changing the repository
            - the Rest API response is huge so i used mappers in my models
                
            example: weatherResponse is all data from the REST API and basic_weather its a generic model
             fun converter(data: weatherResponse): basic_weather {
                        return basic_weather(
                            data.name.toString(),
                            data.main?.temp?.toInt() ?: 0,
                            data.weather?.get(0)?.description.toString(),
                            data.weather?.get(0)?.icon.toString()
                
                        )
                    }


    - Dependency injection with Dagger and Hilt for better performance and memory
            - Network Module for retrofit for multiple requests
    - Navigation Component for navigation
    - ViewModel Layer: presentation package (Screens and View Models)
            - we use the view models for linking our screen with the repository (injected)
    - utils (constants) for a better performance


 Flavors in gradle
    - We used flavors for different version of the App,this is so useful for paid or free versions

Espresso Tests with Hilt
    - Basic Test for Jetpack Compose
    - Test mocking a viewmodel injected on a Screen

 My actual location adn weather is shown on screen (location permission were required)
 There is a search box named Enter City, when enter a city name and click on Search button the screen will display the city information

In the future i will obfuscate the code with pro guard and will use Secrets for storing sensitive data
I will test my aplication using Frida server, Burp Suite and ABD for ethical tetsing.

 my time ran out and i coulnd't save my last location but the shared preferences and dataStore managers were created

 this project will be updated frequently
 
