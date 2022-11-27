package com.example.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.ui.details.MealsDetailsViewModel
import com.example.mealzapp.ui.mealz.MealsCategoryScreen
import com.example.mealzapp.ui.mealz.MealsDetailScreen
import com.example.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealzApp()
            }
        }
    }
}

@Composable
private fun MealzApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Meals_List") {
        composable(route = "Meals_List") {
            MealsCategoryScreen { navigationMealsId ->
                navController.navigate("Meals_Details/$navigationMealsId")
            }
        }
        composable(
            route = "Meals_Details/{meals_category_id}",
            arguments = listOf(navArgument("meals_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealsDetailsViewModel = viewModel()
            MealsDetailScreen(viewModel.mealState.value,navController)
        }
    }
}

