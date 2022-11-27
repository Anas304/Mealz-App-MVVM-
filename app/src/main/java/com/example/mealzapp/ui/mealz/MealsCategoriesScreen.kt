package com.example.mealzapp.ui.mealz

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import com.example.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealsCategoryScreen(navigationCallback: (String) -> Unit) {

    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value
    Surface(
        color = Color.White
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
        ) {
            items(meals) { meal ->
                MealsCategory(meal, navigationCallback)
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealsCategory(meal: MealsSingleObjectResponse, navigationCallback: (String) -> Unit) {

    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { navigationCallback(meal.id) },
        elevation = 50.dp,
        backgroundColor = Color.White,

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
            ) {

                Image(
                    painter = rememberImagePainter(data = meal.imageUrl), contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(4.dp)
                )

                Text(text = meal.name, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.padding(5.dp))
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = meal.description,
                        style = MaterialTheme.typography.subtitle2,
                        maxLines = if (isExpanded) 10 else 3,
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
/*
            Icon(

                imageVector = if (isExpanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expandable Icon Description",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { isExpanded = !isExpanded }
            )*/


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoryScreen { }
    }
}
