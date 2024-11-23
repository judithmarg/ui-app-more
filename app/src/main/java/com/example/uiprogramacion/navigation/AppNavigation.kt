package com.example.uiprogramacion.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.Movie
import com.example.uiprogramacion.screen.CinemaMap
import com.example.uiprogramacion.screen.MovieDetailScreen
import com.example.uiprogramacion.screen.MoviesScreen
import com.example.uiprogramacion.viewmodel.MovieViewModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.MoviesScreen.route
    ) {
        composable(Screens.MoviesScreen.route) {
            val movieViewModel: MovieViewModel = hiltViewModel()
            MoviesScreen(
                onClick = { movieId ->
                    navController.navigate("${Screens.MovieDetailScreen.route}/${movieId}")
                },
                movieViewModel
            )
        }
        composable(
            route = "${Screens.MovieDetailScreen.route}/{movieId}",
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.StringType
                }
            )
        ) {
            MovieDetailScreen(
                onBackPressed = {
                    navController.popBackStack()
                },
                movieId = it.arguments?.getString("movieId ")?: ""
            )
        }
        composable(Screens.CinemaMapScreen.route) {
            CinemaMap()
        }
    }
}
