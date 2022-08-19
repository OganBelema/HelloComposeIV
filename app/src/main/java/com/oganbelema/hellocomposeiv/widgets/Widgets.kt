package com.oganbelema.hellocomposeiv.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.oganbelema.hellocomposeiv.R
import com.oganbelema.hellocomposeiv.model.Movie
import com.oganbelema.hellocomposeiv.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies(LocalContext.current)[0],
             onItemClick: (String) -> Unit = {}) {
    val expanded = remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(movie.title)
        },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = 6.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp) {
                Image(painter = rememberAsyncImagePainter(model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(movie.poster)
                    .error(R.drawable.ic_movie)
                    .crossfade(true)
                    .transformations(listOf(CircleCropTransformation()))
                    .build()),
                contentDescription = "Movie image")
            }
            
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = movie.title,
                style = MaterialTheme.typography.h6)

                Text(text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.caption)

                Text(text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.caption)
                
                AnimatedVisibility(visible = expanded.value) {

                    Column() {
                        Text(text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Yellow,
                            fontSize = 13.sp)) {
                                append("Plot: ")
                            }

                            withStyle(style = SpanStyle(color = Color.Yellow,
                                fontSize = 13.sp,
                            fontWeight = FontWeight.Bold)) {
                                append(movie.plot)
                            }
                        })
                    }
                }

                Icon(imageVector = if (expanded.value) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded.value = !expanded.value
                        },
                    tint = Color.Gray)
            }

        }

    }
}