package com.example.mealzapp.ui.mealz


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.repository.MealsRepo
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepo = MealsRepo.getInstance()) :
    ViewModel() {
    val mealsState: MutableState<List<MealsSingleObjectResponse>> =
        mutableStateOf(emptyList<MealsSingleObjectResponse>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMealsResponse()
            mealsState.value = meals
        }
    }

    private suspend fun getMealsResponse(): List<MealsSingleObjectResponse> {
        return repository.getMealsResponse().myCategories
    }
}