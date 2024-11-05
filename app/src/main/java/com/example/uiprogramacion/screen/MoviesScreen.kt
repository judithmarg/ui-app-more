package com.example.uiprogramacion.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.uiprogramacion.Movie

@Composable
fun MoviesScreen(onClick: (Any?) -> Unit){
    val movie = Movie(id = 1, name = "g", description = "ff")
    Scaffold(
        content = {
            paddingValues -> MoviesScreenContent(
            modifier = Modifier.
            padding(paddingValues),
                onClick = onClick(movie)
            )
        }
    )
}

@Composable
fun MoviesScreenContent(modifier: Modifier, onClick: () -> Unit) {
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                onClick()
            }
        ) {
            Text(text = "Ir al detalle")
        }
    }

}