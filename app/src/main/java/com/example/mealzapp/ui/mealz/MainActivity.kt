package com.example.mealzapp.ui.mealz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import com.example.mealzapp.ui.theme.MealzAppTheme
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealsCategoryScreen()
            }
        }
    }
}

@Composable
fun MealsCategoryScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberMeals: MutableState<List<MealsSingleObjectResponse>> =
        remember { mutableStateOf(emptyList<MealsSingleObjectResponse>()) }
    val coroutineScope = rememberCoroutineScope()

    /** Launched a Coroutine in Composable function with LaunchedEffect*/
    LaunchedEffect(key1 = "GET_MEALS") {
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMealsResponse()
            rememberMeals.value = meals
        }
    }

    LazyColumn {
        items(rememberMeals.value) { meal ->
            Text(text = meal.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoryScreen()
    }
}