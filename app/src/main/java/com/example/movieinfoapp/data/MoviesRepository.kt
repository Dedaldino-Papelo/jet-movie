package com.example.movieinfoapp.data

import com.example.movieinfoapp.model.MovieDetails
import com.example.movieinfoapp.model.MovieList
import com.example.movieinfoapp.network.MovieApi

interface MoviesRepository {
    suspend fun getMovies() : MovieList
    suspend fun getMovieById(id: Int): MovieDetails
}

class NetworkMoviesRepository() : MoviesRepository{
    override suspend fun getMovies(): MovieList {
        return MovieApi.retrofitService.getMovies()
    }

    override suspend fun getMovieById(id: Int): MovieDetails {
        return MovieApi.retrofitService.getMovieById(id = id)
    }
}