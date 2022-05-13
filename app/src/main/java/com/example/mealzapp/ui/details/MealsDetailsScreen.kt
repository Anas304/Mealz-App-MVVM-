package com.example.mealzapp.ui.mealz

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import com.example.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealsDetailScreen(meal: MealsSingleObjectResponse?) {

    var profilePictureState by remember { mutableStateOf(MealsProfilePictureState.Normal) }

    val transition = updateTransition(targetState = profilePictureState, label = "")

    val imageSizeDP by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val borderWidth by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")

    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = borderWidth,
                    color = color
                )
            ) {
                Image(
                    painter = rememberImagePainter(data = meal?.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(imageSizeDP)
                )
            }
            Text(
                text = meal?.name ?: "default name",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(16.dp)
            )
        }
        Button(modifier = Modifier.padding(16.dp),
            onClick = {
                profilePictureState = if (profilePictureState == MealsProfilePictureState.Normal)
                    MealsProfilePictureState.Expanded
                else MealsProfilePictureState.Normal
            }) {
            Text(text = "Change state of meal profile picture")
        }
    }
}

//TODO Change this enum class to Sealed class in future for more dynamic handling.
enum class MealsProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(color = Color.Magenta, size = 130.dp, borderWidth = 2.dp),
    Expanded(color = Color.Green, size = 240.dp, borderWidth = 4.dp)
}
