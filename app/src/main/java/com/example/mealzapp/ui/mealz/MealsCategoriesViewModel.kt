package com.example.mealzapp.ui.mealz

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealzapp.model.MealsRepo
import com.example.mealzapp.model.response.MealsCategoriesResponse
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepo = MealsRepo()) : ViewModel() {


    init {
        Log.d("TAG_Coroutine","We are about to launch a coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_Coroutine","We have launched the coroutine")
            val meals = getMealsResponse()
            Log.d("TAG_Coroutine","We have received the async data")
            mealsState.value = meals
        }
        Log.d("TAG_Coroutine","Other Work!!")
    }

    val mealsState: MutableState<List<MealsSingleObjectResponse>> =
        mutableStateOf(emptyList<MealsSingleObjectResponse>())

    private suspend fun getMealsResponse(): List<MealsSingleObjectResponse> {
        return repository.getMealsResponse().categories
    }
}