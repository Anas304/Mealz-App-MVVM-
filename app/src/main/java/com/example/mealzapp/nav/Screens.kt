package com.example.mealzapp.nav

sealed class Screens(val route: String) {
    object MealsCategoryScreen : Screens(route = "Meals_Category_Screen")
    object MealsDetailScreen : Screens(route = "Meals_Details")
}
