package com.example.uiprogramacion.navigation

sealed class Screens(val route: String) {
    object MoviesScreen: Screens("movies")
    object MovieDetailScreen: Screens("movieDetail")
    object CinemaScreen: Screens("cinema")
    object CinemaDetailScreen: Screens("cinemadetail")
    object CinemaMapScreen: Screens("cinemamap")
}