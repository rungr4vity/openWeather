package il.pacolo.com.appweather.presentation.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class HomeScreenKtTest {

//    @Test
//    fun weatherScreen() {
//    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun greetingDisplaysCorrectName() {

        // Set the content to be tested
        composeTestRule.setContent {
            Greeting("Jetpack Compose")
        }
        // Find the node with the text "Hello, Jetpack Compose!" and assert it's displayed
        composeTestRule.onNodeWithText("Hello, Jetpack Compose!").assertIsDisplayed()
    }
}