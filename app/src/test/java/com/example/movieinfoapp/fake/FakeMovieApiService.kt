package com.example.movieinfoapp.fake

import com.example.movieinfoapp.model.MovieDetails
import com.example.movieinfoapp.model.MovieList
import com.example.movieinfoapp.network.MovieApiService

class FakeMovieApiService: MovieApiService {
    override suspend fun getMovies(): MovieList {
        return FakeDataSource.movieList
    }
    override suspend fun getMovieById(id: Int): MovieDetails {
        TODO("Not yet implemented")
    }
    override suspend fun getMovieBySearch(query: String): MovieList {
        TODO("Not yet implemented")
    }
}