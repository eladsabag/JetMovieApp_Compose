package com.example.jetmovieapp_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetmovieapp_compose.screens.home.HomeScreen
import com.example.jetmovieapp_compose.screens.home.details.DetailsScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            // here we pass where this should lead us to
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}