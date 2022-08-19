package com.oganbelema.hellocomposeiv.screens.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movie: String?) {
    if (movie != null) {
        Text(text = movie)
    }
}