import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jameszooexcercise.presentation.compose.AnimalCard
import com.example.jameszooexcercise.presentation.uimodel.AnimalSearchScreenModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AnimalCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun animalCardShows() {
        composeTestRule.setContent {
            AnimalCard(
                animalData = AnimalSearchScreenModel(
                    name = "name",
                    phylum = "phylum",
                    scientificName = "scientificName"
                )
            )
        }

        composeTestRule.onNodeWithText("name")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("phylum")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("scientificName")
            .assertIsDisplayed()
    }
}
