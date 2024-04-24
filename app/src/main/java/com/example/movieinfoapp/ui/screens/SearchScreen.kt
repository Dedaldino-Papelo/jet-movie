package com.example.movieinfoapp.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieinfoapp.R
import com.example.movieinfoapp.model.Movie

@Composable
fun SearchScreen(
    value: String,
    onValueChange: (String) -> Unit,
    movies: MovieUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.auth_bg_color)),
    ) {
        SearchBar(
            searchText = value,
            onValueChange = onValueChange,
            modifier = modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth()
        )

        when (movies) {
            is MovieUiState.Loading -> LoadingMoviesScreen(modifier = modifier)
            is MovieUiState.Success -> MoviesGrid(
                movies = movies.movies,
                modifier = modifier
                    .fillMaxSize()
            )

            is MovieUiState.Error -> ErrorMoviesScreen()
        }

    }
}

@Composable
fun MoviesGrid(
    movies: List<Movie>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(items = movies, key = { movie -> movie.id }) { movie ->
            MovieCard(
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
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
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

@Composable
fun LoadingMoviesScreen(modifier: Modifier = Modifier) {
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
fun ErrorMoviesScreen() {
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier,
        value = searchText,
        onValueChange = onValueChange,
        label = {
            Text(
                text = "Search for a title...",
                color = colorResource(R.color.button_color)
            )
        },
        textStyle = TextStyle(
            colorResource(R.color.button_color),
            fontSize = 20.sp
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                tint = colorResource(R.color.button_color),
                contentDescription = null
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = colorResource(R.color.button_color),
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(50.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = colorResource(R.color.searchBar_color),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

