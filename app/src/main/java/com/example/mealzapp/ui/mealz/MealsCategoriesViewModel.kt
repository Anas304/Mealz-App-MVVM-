package com.example.mealzapp.ui.mealz

import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRepo
import com.example.mealzapp.model.response.MealsCategoriesResponse
import com.example.mealzapp.model.response.MealsSingleObjectResponse

class MealsCategoriesViewModel(private val repository: MealsRepo = MealsRepo()) : ViewModel() {

    fun getMealsResponse(): List<MealsSingleObjectResponse> {
        return repository.getMealsResponse()?.categories.orEmpty()
    }
}