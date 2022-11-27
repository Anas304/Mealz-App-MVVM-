package com.example.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.repository.MealsRepo
import com.example.mealzapp.model.response.MealsSingleObjectResponse

class MealsDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,

) : ViewModel() {
    private val repository: MealsRepo = MealsRepo.getInstance()
    var mealState = mutableStateOf<MealsSingleObjectResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meals_category_id") ?: ""
        mealState.value = repository.getMealById(mealId)
    }

}