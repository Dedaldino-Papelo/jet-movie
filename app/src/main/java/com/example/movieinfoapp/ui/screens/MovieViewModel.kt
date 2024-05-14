package com.example.movieinfoapp.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.movieinfoapp.MovieApplication
import com.example.movieinfoapp.data.MoviesRepository
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

class MovieViewModel(private val moviesRepository: MoviesRepository): ViewModel(){

    var searchText: String by mutableStateOf("")
        private set

    var movieUiState : MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    var movieDetailsUiState : MovieDetailsUiState by mutableStateOf(MovieDetailsUiState.Loading)
        private set

    var SearchedMoviesState: MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    init {
        getMovies()
    }

    private fun getMovies(){
        viewModelScope.launch {
            movieUiState = MovieUiState.Loading
            try {
                val result = moviesRepository.getMovies()
                movieUiState = MovieUiState.Success(result.results)
            } catch (e: IOException){
                MovieUiState.Error
            }
        }
    }

    fun setMovie(movie: Movie){
        viewModelScope.launch {
            try {
                val response = moviesRepository.getMovieById(id = movie.id)
                movieDetailsUiState = MovieDetailsUiState.Success(response)
                Log.d("moveId", response.toString())
            } catch (e: IOException){
                MovieDetailsUiState.Error
            }
        }
    }

    fun updateSearchText(input: String){
        searchText = input
    }

    fun getMovieBySearch(){
        viewModelScope.launch {
            try {
                val response = moviesRepository.getMovieBySearch(param = searchText)
                SearchedMoviesState = MovieUiState.Success(response.results)
            } catch (e: IOException){
               MovieUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MovieApplication)
                val moviesRepository = application.container.moviesRepository
                MovieViewModel(moviesRepository = moviesRepository)
            }
        }
    }
}