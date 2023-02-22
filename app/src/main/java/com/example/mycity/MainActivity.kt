package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.DetailScreen
import com.example.mycity.ui.HomeScreen
import com.example.mycity.ui.MedanDetailScreen
import com.example.mycity.ui.RecommendationViewModel
import com.example.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyCityApp()
                }
            }
        }
    }
}

enum class MyCityScreen {
    Start,
    Medan_Detail,
    Item_Detail
}

@Composable
fun MyCityApp() {

    val viewModel: RecommendationViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Start.name
    )

    NavHost(navController = navController, startDestination = MyCityScreen.Start.name) {
        composable(route = MyCityScreen.Start.name) {
            HomeScreen(
                recommendation = uiState.placeList,
                onItemDetailClick = {
                    viewModel.updateCurrentPlace(it)
                    navController.navigate(MyCityScreen.Item_Detail.name)
                },
                onMedanDetailClick = {
                    navController.navigate(MyCityScreen.Medan_Detail.name)
                }
            )
        }

        composable(route = MyCityScreen.Medan_Detail.name) {
            MedanDetailScreen(
                onBackClick = {
                    navController.navigate(MyCityScreen.Start.name)
                }
            )
        }

        composable(route = MyCityScreen.Item_Detail.name) {
            DetailScreen(
                selectedRecommendation = uiState.currentPlace,
                onBackPressed = { navController.navigate(MyCityScreen.Start.name) }
            )
        }
    }


}

@Preview()
@Composable
fun DefaultPreview() {
    MyCityTheme(darkTheme = false) {
        MyCityApp()
    }
}