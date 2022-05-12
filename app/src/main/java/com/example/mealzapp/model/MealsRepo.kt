package com.example.mealzapp.model

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealsCategoriesResponse
import com.example.mealzapp.model.response.MealsSingleObjectResponse

class MealsRepo(private val webService: MealsWebService = MealsWebService()) {

    private var cacheMeals = listOf<MealsSingleObjectResponse>()

   suspend fun getMealsResponse(): MealsCategoriesResponse {
       val response = webService.getMeals()
        cacheMeals =  response.categories
       return response
    }

    fun getMealById(id : String) : MealsSingleObjectResponse? {
       return cacheMeals.firstOrNull(){
            it.id == id
        }
    }
}