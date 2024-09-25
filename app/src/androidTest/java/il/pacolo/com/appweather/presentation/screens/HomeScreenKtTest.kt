package il.pacolo.com.appweather.presentation.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import il.pacolo.com.appweather.MainActivity
import il.pacolo.com.appweather.data.DataRepository
import il.pacolo.com.appweather.presentation.viewmodels.HomeViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class HomeScreenKtTest {
    // in jetpack compose elements are represented by nodes

    @get:Rule
    val rule = createComposeRule()

    // Hilt
    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    @Inject
    lateinit var viewModel: HomeViewModel

    @Before
    fun init() {
        hiltRule.inject()
    }

    // basic espresso test search a textbox named "Enter city" and assert it's displayed search button
    // mock data repository and viewmodel
    @Test
    fun testScreenDisplaysLoadingState() {
        // Mock ViewModel state

        composeTestRule.setContent {
            WeatherScreen(viewModel = (HomeViewModel(mock(DataRepository::class.java))))
        }
        // Assert the loading state is displayed
        composeTestRule.onNodeWithContentDescription("Enter city")
            .assertIsDisplayed()
    }

    class FakeViewModel(
        dataRepository: DataRepository
    ) : HomeViewModel(dataRepository)


    @Test
    fun greetingDisplaysCorrectName() {

        // basic espresso test
        rule.setContent {
            Greeting("Jetpack Compose")
        }
        // Find the node with the text "Hello, Jetpack Compose!" and assert it's displayed
        rule.onNodeWithText("Hello, Jetpack Compose!").assertIsDisplayed()
    }


    // basic espresso test search a textbox named "Enter city"
    @Test
    fun searchCity() {

        rule.setContent { WeatherScreen() }
        rule.onNodeWithText("Enter city").performTextInput("London")
        rule.onNodeWithText("Search").performClick()
        rule.onNodeWithText("London").assertIsDisplayed()
    }








}