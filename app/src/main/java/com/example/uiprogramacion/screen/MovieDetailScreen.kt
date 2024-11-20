package com.example.uiprogramacion.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.compose.LocalLifecycleOwner
import coil.compose.AsyncImage
import com.example.domain.Movie
import com.example.uiprogramacion.ui.theme.Pink40
import com.example.uiprogramacion.util.showNotification
import com.example.uiprogramacion.viewmodel.MovieDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(onBackPressed: ()-> Unit, movieId:String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "MovieDetails")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed,
                        content = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    )
                }
            )
        },
        content = {
            paddingValues -> MovieDetailScreenContent(modifier=Modifier.padding(paddingValues)
            , movieId = movieId)
        }
    )
}

@Composable
fun MovieDetailScreenContent(modifier: Modifier, movieId: String){
    Log.d("MovieDetailScreenContent", "MovieDetailScreenContent UI")
    val viewModel = MovieDetailViewModel()


    var movieUI by remember { mutableStateOf(Movie(1, "", "", "")) }


    viewModel.findMovie(LocalContext.current, movieId)
    val context = LocalContext.current

    fun updateUI(movieDetailState: MovieDetailViewModel.MovieDetailState) {
        when ( movieDetailState) {
            is MovieDetailViewModel.MovieDetailState.Error -> {
                Toast.makeText(context, "Error ${movieDetailState.message}", Toast.LENGTH_SHORT).show()
            }
            is MovieDetailViewModel.MovieDetailState.Loading -> {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }
            is MovieDetailViewModel.MovieDetailState.Successful -> {
                movieUI = movieDetailState.movie
            }
        }
    }
    viewModel.state.observe(
        LocalLifecycleOwner.current,
        Observer(::updateUI)
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Pink40)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w185/${movieUI.posterPath}",
            contentDescription = "MoviePoster",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(280.dp)
                .width(260.dp)

        )
        Text(text = movieUI.title, color = Color.White, fontSize = 26.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "genial" + movieUI.description, color = Color.White)
        IconButton(
            onClick = {
                showNotification(context)
            }
        ) {
            Icon(
                Icons.Default.Notifications,
                contentDescription = null
            )
        }
    }

}