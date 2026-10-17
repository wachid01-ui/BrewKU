package com.brewku.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.brewku.app.ads.InterstitialAdManager
import com.brewku.app.data.model.Recipe
import com.brewku.app.ui.screens.BrewResultScreen
import com.brewku.app.ui.screens.BrewTimerScreen
import com.brewku.app.ui.screens.HomeScreen
import com.brewku.app.ui.screens.RecipeDetailScreen
import com.brewku.app.ui.screens.TroubleshootScreen
import com.brewku.app.ui.theme.BrewKuTheme

sealed interface Screen {
    data object Home : Screen
    data class Detail(val recipe: Recipe) : Screen
    data class Timer(val recipe: Recipe, val coffeeGrams: Float, val waterVolumeMl: Int) : Screen
    data class Result(val recipe: Recipe, val coffeeGrams: Float, val waterVolumeMl: Int) : Screen
    data object Doctor : Screen
}

class MainActivity : ComponentActivity() {

    private lateinit var interstitialAdManager: InterstitialAdManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Preload Interstitial Ad segera setelah Activity dibuat
        interstitialAdManager = InterstitialAdManager(this)

        setContent {
            BrewKuTheme {
                BrewKuAppNavigator(interstitialAdManager = interstitialAdManager)
            }
        }
    }
}

@Composable
fun BrewKuAppNavigator(
    interstitialAdManager: InterstitialAdManager
) {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    BackHandler(enabled = currentScreen !is Screen.Home) {
        currentScreen = when (currentScreen) {
            is Screen.Detail -> Screen.Home
            is Screen.Timer -> Screen.Detail((currentScreen as Screen.Timer).recipe)
            is Screen.Result -> Screen.Home
            is Screen.Doctor -> Screen.Home
            Screen.Home -> Screen.Home
        }
    }

    AnimatedContent(
        targetState = currentScreen,
        transitionSpec = {
            (slideInHorizontally { width -> width } + fadeIn()).togetherWith(
                slideOutHorizontally { width -> -width } + fadeOut()
            )
        },
        label = "ScreenTransition"
    ) { screen ->
        when (screen) {
            is Screen.Home -> {
                HomeScreen(
                    onSelectRecipe = { currentScreen = Screen.Detail(it) },
                    onOpenDoctor = { currentScreen = Screen.Doctor }
                )
            }
            is Screen.Detail -> {
                RecipeDetailScreen(
                    recipe = screen.recipe,
                    onBack = { currentScreen = Screen.Home },
                    onStartTimer = { recipe, grams, water ->
                        currentScreen = Screen.Timer(recipe, grams, water)
                    }
                )
            }
            is Screen.Timer -> {
                BrewTimerScreen(
                    recipe = screen.recipe,
                    coffeeGrams = screen.coffeeGrams,
                    waterVolumeMl = screen.waterVolumeMl,
                    onCancel = { currentScreen = Screen.Detail(screen.recipe) },
                    onBrewComplete = { recipe, grams, water ->
                        currentScreen = Screen.Result(recipe, grams, water)
                    }
                )
            }
            is Screen.Result -> {
                BrewResultScreen(
                    recipe = screen.recipe,
                    coffeeGrams = screen.coffeeGrams,
                    waterVolumeMl = screen.waterVolumeMl,
                    interstitialAdManager = interstitialAdManager,
                    onGoHome = { currentScreen = Screen.Home },
                    onOpenDoctor = { currentScreen = Screen.Doctor }
                )
            }
            is Screen.Doctor -> {
                TroubleshootScreen(
                    onBack = { currentScreen = Screen.Home }
                )
            }
        }
    }
}
