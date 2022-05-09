package com.example.mealzapp.model

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealsCategoriesResponse

class MealsRepo(private val webService: MealsWebService = MealsWebService()) {
    fun getMealsResponse(): MealsCategoriesResponse?{
        return webService.getMeals().execute().body() //bad practice, It will block the main thread..
    }
}