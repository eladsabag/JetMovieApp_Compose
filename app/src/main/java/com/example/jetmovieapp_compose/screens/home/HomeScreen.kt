package com.example.jetmovieapp_compose.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetmovieapp_compose.model.Movie
import com.example.jetmovieapp_compose.model.getMovies
import com.example.jetmovieapp_compose.navigation.MovieScreens
import com.example.jetmovieapp_compose.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    LazyColumn {
        items(items = movieList) {
            MovieRow(movie = it) { movie ->
                navController.navigate(
                    route = MovieScreens.DetailScreen.name + "/$movie"
                )
            }
        }
    }
}