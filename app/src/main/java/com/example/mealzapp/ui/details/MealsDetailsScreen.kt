package com.example.mealzapp.ui.mealz

import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzapp.R
import com.example.mealzapp.model.response.MealsSingleObjectResponse
import com.example.mealzapp.nav.Screens
import kotlin.math.min

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealsDetailScreen(meal: MealsSingleObjectResponse?) {

    //Scroll Animations
    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f))
    val sizeAnim by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))

    val navController = rememberNavController()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = meal?.name ?: "default name",
                        style = MaterialTheme.typography.h6,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Require Additional work but you can use default back button",
                            Toast.LENGTH_LONG
                        ).show()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        },

        content = {
            // Body content

            Column() {
                Surface(elevation = 4.dp) {
                    Row(modifier = Modifier.fillMaxWidth()) {

                        Image(
                            painter = rememberImagePainter(data = meal?.imageUrl,
                                builder = {
                                    //transformations(CircleCropTransformation())
                                }),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 60.dp, 16.dp)
                                .size(sizeAnim),
                        )
                    }
                }

                //Top Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        modifier = Modifier.padding(20.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_date_range_24),
                        contentDescription = ""
                    )
                    Text(text = "Reading time  3mins")

                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))

                    Image(
                        modifier = Modifier.padding(20.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_access_time),
                        contentDescription = ""
                    )
                    Text(text = "2 Nov 2022")


                }

                Column(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RectangleShape,
                        border = BorderStroke(25.dp, Color.Transparent)
                    ) {
                        Column() {
                            Text(
                                text = "Heading 1",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 23.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                if (meal != null) {
                                    Text(
                                        text = meal.description,
                                        style = MaterialTheme.typography.subtitle2,

                                        textAlign = TextAlign.Start,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical = 2.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RectangleShape,
                        border = BorderStroke(25.dp, Color.Transparent)
                    ) {
                        Column() {
                            Text(
                                text = "Heading 2",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 23.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                if (meal != null) {
                                    Text(
                                        text = meal.description,
                                        style = MaterialTheme.typography.subtitle2,

                                        textAlign = TextAlign.Start,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 2.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RectangleShape,
                        border = BorderStroke(25.dp, Color.Transparent)
                    ) {
                        Column() {
                            Text(
                                text = "Heading 3",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 23.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                if (meal != null) {
                                    Text(
                                        text = meal.description,
                                        style = MaterialTheme.typography.subtitle2,

                                        textAlign = TextAlign.Start,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 2.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RectangleShape,
                        border = BorderStroke(25.dp, Color.Transparent)
                    ) {
                        Column() {
                            Text(
                                text = "Heading 4",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 23.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                if (meal != null) {
                                    Text(
                                        text = meal.description,
                                        style = MaterialTheme.typography.subtitle2,

                                        textAlign = TextAlign.Start,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 2.dp))



                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RectangleShape,
                        border = BorderStroke(25.dp, Color.Transparent)
                    ) {
                        Column() {
                            Text(
                                text = "Heading 5",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 23.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                if (meal != null) {
                                    Text(
                                        text = meal.description,
                                        style = MaterialTheme.typography.subtitle2,

                                        textAlign = TextAlign.Start,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 2.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RectangleShape,
                        border = BorderStroke(25.dp, Color.Transparent)
                    ) {
                        Column() {
                            Text(
                                text = "Heading 6",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 23.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                if (meal != null) {
                                    Text(
                                        text = meal.description,
                                        style = MaterialTheme.typography.subtitle2,

                                        textAlign = TextAlign.Start,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(vertical = 2.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RectangleShape,
                        border = BorderStroke(25.dp, Color.Transparent)
                    ) {
                        Column() {
                            Text(
                                text = "Heading 7",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontSize = 23.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 2.dp))
                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                if (meal != null) {
                                    Text(
                                        text = meal.description,
                                        style = MaterialTheme.typography.subtitle2,

                                        textAlign = TextAlign.Start,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }


                }

            }
        }
    )

    Surface(color = MaterialTheme.colors.background) {

    }


}

enum class MealsProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(color = Color.Magenta, size = 130.dp, borderWidth = 2.dp),
    Expanded(color = Color.Green, size = 240.dp, borderWidth = 4.dp)
}
