package com.example.mealzapp.ui.mealz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import com.example.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealsDetailScreen(meal: MealsSingleObjectResponse) {
    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(data = meal.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(text = meal.name, style = MaterialTheme.typography.h6)
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Change state of meal profile picture")
        }
    }
}
