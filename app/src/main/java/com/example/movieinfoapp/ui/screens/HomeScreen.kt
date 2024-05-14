package com.example.movieinfoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieinfoapp.R
import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.ui.theme.MovieInfoAppTheme

@Composable
fun HomeScreen(
    onClick: (Movie) -> Unit,
    movieUiState: MovieUiState,
    modifier: Modifier = Modifier
){
    when (movieUiState) {
        is MovieUiState.Loading -> LoadingScreen(
            modifier = modifier
                .background(colorResource(R.color.auth_bg_color))
        )
        is MovieUiState.Success -> MoviesGridScreen(
            onClick = onClick,
            movies = movieUiState.movies,
            modifier = modifier
                .fillMaxSize()
                .background(colorResource(R.color.auth_bg_color))
        )

        is MovieUiState.Error -> ErrorScreen(
            modifier = modifier
                .fillMaxSize()
                .background(colorResource(R.color.auth_bg_color))
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
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
fun ErrorScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Failed to load",
            fontSize = 24.sp
        )
    }
}

@Composable
fun MoviesGridScreen(
    onClick: (Movie) -> Unit,
    movies: List<Movie>,
    modifier: Modifier = Modifier){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ){
        items(items = movies, key = { movie -> movie.id  } ) { movie ->
            MovieCard(
                onClick = { onClick(movie) },
                movie = movie,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
            )
        }
    }
}

@Composable
fun MovieCard(
    onClick: () -> Unit,
    movie: Movie,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                .crossfade(true)
                .build(),
            contentDescription = "movie",
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview(){
    MovieInfoAppTheme {
        LoadingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesGridScreenPreview() {
    MovieInfoAppTheme {
        val mockData = List(10) { Movie(
            false,
            "",
            listOf(1,2,3),
            2,
            "",
            "",
            "",
            23.4,
            "",
            "",
            "", true, 34.4, 34) }
        MoviesGridScreen(onClick = {}, mockData)
    }
}