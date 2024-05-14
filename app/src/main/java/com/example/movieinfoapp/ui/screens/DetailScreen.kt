package com.example.movieinfoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieinfoapp.R
import com.example.movieinfoapp.model.MovieDetails

@Composable
fun DetailScreen(
    movie: MovieDetailsUiState
){
    when(movie) {
        is MovieDetailsUiState.Loading -> Loading(modifier = Modifier.fillMaxSize())
        is MovieDetailsUiState.Success -> MoveDetailsScreen(
            movie = movie.movieDetails)
        is MovieDetailsUiState.Error -> ErrorScreen()
    }
}

@Composable
fun Loading(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = modifier.size(60.dp),
            color = colorResource(R.color.button_color),
            strokeWidth = 8.dp,
        )
    }
}
@Composable
fun ErrorScreen(){}

@Composable
fun MoveDetailsScreen(
    movie: MovieDetails,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.auth_bg_color))
    ) {
        Box(
            modifier = modifier,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                    .crossfade(true)
                    .build(),
                contentDescription = "movie",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )
        }
        
        Spacer(modifier = modifier.height(11.dp))

        Column(
            modifier = modifier
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = movie.title,
                fontSize = 20.sp,
                color = colorResource(R.color.white),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(11.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = movie.releaseDate.toString(),
                    color = colorResource(R.color.date_info),
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = modifier.height(11.dp))

            Column {
                Text(
                    text = movie.overview.toString(),
                    color = colorResource(R.color.white),
                    fontSize = 14.sp
                )
                Spacer(modifier = modifier.height(11.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Genre : ",
                        color = colorResource(R.color.white),
                        fontSize = 13.sp,
                    )
                    movie.genres.forEach { genre ->
                        Text(
                            text = genre.name,
                            color = colorResource(R.color.white),
                            fontSize = 13.sp,
                            modifier = modifier
                                .padding(end = 6.dp)
                        )
                    }
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    MovieInfoAppTheme {
        DetailScreen(
            movie = { }
        )
    }
}*/
