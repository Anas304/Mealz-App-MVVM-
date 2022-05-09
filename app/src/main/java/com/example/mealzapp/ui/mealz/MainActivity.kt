package com.example.mealzapp.ui.mealz
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealzapp.ui.theme.MealzAppTheme

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
    val viewModel : MealsCategoriesViewModel = viewModel()
    val meals = viewModel.getMealsResponse()
    Text(text = meals.toString())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoryScreen()
    }
}