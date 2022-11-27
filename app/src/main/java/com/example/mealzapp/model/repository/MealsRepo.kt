package com.example.mealzapp.model.repository

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealsCategoriesResponse
import com.example.mealzapp.model.response.MealsSingleObjectResponse

class MealsRepo(private val webService: MealsWebService = MealsWebService()) {

    private var cacheMeals = listOf<MealsSingleObjectResponse>()

    suspend fun getMealsResponse(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cacheMeals = response.myCategories
        return response
    }

    fun getMealById(id: String): MealsSingleObjectResponse? {
        return cacheMeals.firstOrNull() {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepo? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealsRepo().also { instance = it }
        }
    }
}