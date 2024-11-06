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
import com.example.domain.Movie

@Composable
fun MoviesScreen(onClick: (com.example.domain.Movie) -> Unit){
    Scaffold(
        content = {
            paddingValues -> MoviesScreenContent(
            modifier = Modifier.
            padding(paddingValues),
                onClick = onClick
            )
        }
    )
}

@Composable
fun MoviesScreenContent(modifier: Modifier, onClick: (com.example.domain.Movie) -> Unit) {
    val movie = com.example.domain.Movie(
        title = "Titanes del Pacifico",
        description = "Hace mucho tiempo, legiones de criaturas monstruosas llamados Kaiju surgen del mar, llevando consigo una guerra. Para pelear a los Kaiju, la humanidad desarrolla robots gigantes llamados Jaegers, diseñados para ser piloteados por dos humanos. Sin embargo, ni los Jaegers son suficientes para vencer a los Kaiju, y la humanidad está al borde de la derrota. La última esperanza de la humanidad descansa en un expiloto fracasado, un aprendiz y un viejo y obsoleto Jaeger."
    )

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                onClick(movie)
            }
        ) {
            Text(text = "Ir al detalle")
        }
    }

}