package com.example.movieinfoapp.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieinfoapp.data.NetworkMoviesRepository
import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.model.MovieDetails
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MovieUiState {
    data class Success(val movies: List<Movie>) : MovieUiState
    object Error : MovieUiState
    object Loading : MovieUiState
}

sealed interface MovieDetailsUiState {
    data class Success(val movieDetails: MovieDetails) : MovieDetailsUiState
    object Error : MovieDetailsUiState
    object Loading : MovieDetailsUiState
}

class MovieViewModel: ViewModel(){
    var movieUiState : MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    var movieDetailsUiState : MovieDetailsUiState by mutableStateOf(MovieDetailsUiState.Loading)
        private set

    init {
        getMovies()
    }

    private fun getMovies(){
        viewModelScope.launch {
            try {
                val moviesRepository = NetworkMoviesRepository()
                val result = moviesRepository.getMovies()
                movieUiState = MovieUiState.Success(result.results)
            } catch (e: IOException){
                MovieUiState.Error
                Log.d("error", e.toString())
            }
        }
    }

    fun setMovie(movie: Movie){
        viewModelScope.launch {
            try {
                val movieRepository = NetworkMoviesRepository()
                val response = movieRepository.getMovieById(id = movie.id)
                movieDetailsUiState = MovieDetailsUiState.Success(response)
                Log.d("moveId", response.toString())
            } catch (e: IOException){
                MovieDetailsUiState.Error
            }
        }
    }
}