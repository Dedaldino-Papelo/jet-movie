package com.example.movieinfoapp.data

import com.example.movieinfoapp.model.MovieDetails
import com.example.movieinfoapp.model.MovieList
import com.example.movieinfoapp.network.MovieApiService

interface MoviesRepository {
    suspend fun getMovies() : MovieList
    suspend fun getMovieById(id: Int): MovieDetails
    suspend fun getMovieBySearch(param: String): MovieList
}

class NetworkMoviesRepository(private val movieApiService: MovieApiService) : MoviesRepository {
    override suspend fun getMovies(): MovieList {
        return movieApiService.getMovies()
    }
    override suspend fun getMovieById(id: Int): MovieDetails {
        return movieApiService.getMovieById(id = id)
    }

    override suspend fun getMovieBySearch(param: String): MovieList {
        return movieApiService.getMovieBySearch(query = param)
    }
}