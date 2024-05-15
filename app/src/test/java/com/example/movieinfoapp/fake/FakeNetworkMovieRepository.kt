package com.example.movieinfoapp.fake

import com.example.movieinfoapp.data.MoviesRepository
import com.example.movieinfoapp.model.MovieDetails
import com.example.movieinfoapp.model.MovieList

class FakeNetworkMoviesRepository: MoviesRepository {
    override suspend fun getMovies(): MovieList {
        return FakeDataSource.movieList
    }
    override suspend fun getMovieById(id: Int): MovieDetails {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieBySearch(param: String): MovieList {
        TODO("Not yet implemented")
    }
}