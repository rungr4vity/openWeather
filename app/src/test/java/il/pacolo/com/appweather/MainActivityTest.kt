package il.pacolo.com.appweather

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainActivityTest {

 @get:Rule
 val composeTestRule = createAndroidComposeRule<MainActivity>()

 @Test
 fun greetingDisplayCorrectText() {
  composeTestRule.onNodeWithText("Hello, Android!").assertIsDisplayed()
 }

 @Test
 fun activityLaunchesSuccessfully() {
  // You can also grab the Activity instance if you need to inspect non-Compose logic
  val activity = Robolectric
   .buildActivity(MainActivity::class.java)
   .setup()
   .get()

  assertThat(activity, notNullValue())
 }

//    @Test
//    fun `onCreate initializes NavManager`() {
//        // Verify that the NavManager is initialized and set as the content view within the Surface and AppWeatherTheme.
//        // TODO implement test
//    }
//
//    @Test
//    fun `onCreate with null savedInstanceState`() {
//        // Test the onCreate method when the savedInstanceState Bundle is null, which happens when the activity is created for the first time.
//        // TODO implement test
//    }
//
//    @Test
//    fun `onCreate with non null savedInstanceState`() {
//        // Test the onCreate method when the activity is recreated (e.g., after a configuration change) and savedInstanceState contains previously saved data.
//        // TODO implement test
//    }
//
//    @Test
//    fun `onCreate sets up Compose content correctly`() {
//        // Verify that setContent is called and correctly sets up the Composable hierarchy, including AppWeatherTheme, Surface, and NavManager.
//        // TODO implement test
//    }
//
//    @Test
//    fun `onCreate maintains activity lifecycle`() {
//        // Test how onCreate behaves when the activity is brought to the foreground after being in the background, ensuring its state is restored correctly (though in this code, there's no state being saved or restored in onCreate).
//        // This is a general lifecycle test applicable to onCreate.
//        // TODO implement test
//    }
//
//    @Test
//    fun `onCreate performance on initial launch`() {
//        // Measure the time taken for onCreate to execute on the first launch of the application to identify potential performance bottlenecks.
//        // TODO implement test
//    }
//
//    @Test
//    fun `onCreate performance on recreation`() {
//        // Measure the time taken for onCreate to execute when the activity is recreated (e.g., after a rotation) to ensure it's efficient.
//        // TODO implement test
//    }

}