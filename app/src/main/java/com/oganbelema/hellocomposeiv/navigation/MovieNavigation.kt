package com.oganbelema.hellocomposeiv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oganbelema.hellocomposeiv.screens.details.DetailsScreen
import com.oganbelema.hellocomposeiv.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailsScreen.name) {
            DetailsScreen(navController = navController)
        }
    }
}