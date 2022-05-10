package com.example.mealzapp.ui.mealz

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRepo
import com.example.mealzapp.model.response.MealsCategoriesResponse
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepo = MealsRepo()) : ViewModel() {

    private val mealsJob = Job()

    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        scope.launch {
            val meals = getMealsResponse()
            mealsState.value = meals
        }
    }

    val mealsState: MutableState<List<MealsSingleObjectResponse>> =
        mutableStateOf(emptyList<MealsSingleObjectResponse>())


    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

    private suspend fun getMealsResponse(): List<MealsSingleObjectResponse> {
        return repository.getMealsResponse().categories
    }
}