package com.oganbelema.hellocomposeiv.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oganbelema.hellocomposeiv.AppTopBar
import com.oganbelema.hellocomposeiv.model.Movie
import com.oganbelema.hellocomposeiv.model.getMovies
import com.oganbelema.hellocomposeiv.navigation.MovieScreens
import com.oganbelema.hellocomposeiv.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar("Movies")
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movies: List<Movie> = getMovies(LocalContext.current)) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movies) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}