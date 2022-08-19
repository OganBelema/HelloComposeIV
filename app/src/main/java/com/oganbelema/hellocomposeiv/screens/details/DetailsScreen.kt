package com.oganbelema.hellocomposeiv.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.oganbelema.hellocomposeiv.AppTopBar

@Composable
fun DetailsScreen(navController: NavController, movie: String?) {
    if (movie != null) {
        Scaffold(topBar = {
            AppTopBar(
                title = "Movie Detail", isChild = true,
                navController = navController
            )
        }) {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = movie, style = MaterialTheme.typography.h5)
                }
            }
        }
    }
}