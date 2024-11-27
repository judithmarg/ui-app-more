package com.example.uiprogramacion.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.Movie
import com.example.uiprogramacion.TipoCambio
import com.example.uiprogramacion.screen.CinemaMap
import com.example.uiprogramacion.screen.MovieDetailScreen
import com.example.uiprogramacion.screen.MoviesScreen
import com.example.uiprogramacion.screen.PromotionScreen
import com.example.uiprogramacion.viewmodel.MovieViewModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.UUID


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    var uuid = UUID.randomUUID().toString()

    val database = Firebase.database
    val myRef1 = database.getReference("tipo_cambio_venta_oficial")
    var tvoficial by remember { mutableStateOf("") }
    var text = "6.96"
    myRef1.setValue(text)
    myRef1.addValueEventListener( object: ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun onDataChange(p0: DataSnapshot) {
            val value = p0.getValue(String::class.java)
            tvoficial = value.toString()
        }
    })

    val myRef2 = database.getReference("tipo_cambio_compra_oficial")
    var tcoficial by remember { mutableStateOf("") }
    var text2 = "6.95"
    myRef2.setValue(text2)
    myRef2.addValueEventListener( object: ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun onDataChange(p0: DataSnapshot) {
            val value = p0.getValue(String::class.java)
            tcoficial = value.toString()
        }
    })

    val myRef3 = database.getReference("tipo_cambio_venta_paralelo")
    var tvparalelo by remember { mutableStateOf("") }
    var text3 = "11.80"
    myRef3.setValue(text3)
    myRef3.addValueEventListener( object: ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun onDataChange(p0: DataSnapshot) {
            val value = p0.getValue(String::class.java)
            tvparalelo = value.toString()
        }
    })

    val myRef4 = database.getReference("tipo_cambio_compra_paralelo")
    var tcparalelo by remember { mutableStateOf("") }
    var text4 = "12.50"
    myRef4.setValue(text4)
    myRef4.addValueEventListener( object: ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun onDataChange(p0: DataSnapshot) {
            val value = p0.getValue(String::class.java)
            tcparalelo = value.toString()
        }
    })

    NavHost(
        navController = navController,
        startDestination = Screens.PromotionScreen.route
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
                movieId = it.arguments?.getString("movieId")?: ""
            )
        }
        composable(Screens.CinemaMapScreen.route) {
            CinemaMap()
        }
        composable(Screens.PromotionScreen.route) {
            PromotionScreen(tipoCambio = TipoCambio(tcoficial,tvoficial,tcparalelo,tvparalelo))
        }
    }
}
