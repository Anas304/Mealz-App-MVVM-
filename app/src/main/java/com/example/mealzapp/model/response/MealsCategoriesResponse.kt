package com.example.mealzapp.model.response

import com.google.gson.annotations.SerializedName

// Gson deserialization :
// Json -> data class

data class MealsCategoriesResponse(val categories: List<MealsSingleObjectResponse>)

data class MealsSingleObjectResponse(
    @SerializedName("idCategory")  val id: String,
    @SerializedName("strCategory")  val name: String,
    @SerializedName("strCategoryThumb")  val imageUrl: String,
    @SerializedName("strCategoryDescription")  val description: String
)