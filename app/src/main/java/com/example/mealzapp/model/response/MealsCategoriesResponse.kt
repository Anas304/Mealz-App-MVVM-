package com.example.mealzapp.model.response

import com.google.gson.annotations.SerializedName

// Gson deserialization :
// Json -> data class

data class MealsCategoriesResponse(private val categories: List<MealsSingleObjectResponse>)

data class MealsSingleObjectResponse(
    @SerializedName("idCategory") private val id: String,
    @SerializedName("strCategory") private val name: String,
    @SerializedName("strCategoryThumb") private val imageUrl: String,
    @SerializedName("strCategoryDescription") private val description: String
)