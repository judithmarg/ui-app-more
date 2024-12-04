package com.example.uiprogramacion

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uiprogramacion.screen.PromotionScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PromotionScreenTest {


    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun promotionScreen_dispalyCorrectTitle() {
        val testTitle = "Promo"
        composeTestRule.setContent {
            PromotionScreen(TipoCambio("hola1", "hola2","hola3", "hola4"))
        }
        composeTestRule
            .onNodeWithTag("PROMOTION TEST TAG")
            .assertTextEquals(testTitle)
    }


}
