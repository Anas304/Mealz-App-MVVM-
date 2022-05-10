package com.example.mealzapp.model

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealsCategoriesResponse

class MealsRepo(private val webService: MealsWebService = MealsWebService()) {
   suspend fun getMealsResponse(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}