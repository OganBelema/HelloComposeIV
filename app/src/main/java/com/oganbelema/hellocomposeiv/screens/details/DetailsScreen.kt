package com.oganbelema.hellocomposeiv.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.oganbelema.hellocomposeiv.AppTopBar
import com.oganbelema.hellocomposeiv.model.getMovies
import com.oganbelema.hellocomposeiv.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {

    val movieData = getMovies(LocalContext.current).filter {it.id == movieId}[0]

    if (movieId != null) {
        Scaffold(topBar = {
            AppTopBar(
                title = "Movie Detail", isChild = true,
                navController = navController
            )
        }) {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    MovieRow(movie = movieData)
                }
            }
        }
    }
}