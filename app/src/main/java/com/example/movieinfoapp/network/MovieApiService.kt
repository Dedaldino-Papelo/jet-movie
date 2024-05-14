package com.example.movieinfoapp.network

import com.example.movieinfoapp.BuildConfig.API_KEY
import com.example.movieinfoapp.model.MovieDetails
import com.example.movieinfoapp.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApiService {
    @GET("movie/popular?api_key=${API_KEY}")
    suspend fun getMovies(): MovieList

    @GET("movie/{movie_id}?api_key=${API_KEY}")
    suspend fun getMovieById(
        @Path("movie_id") id: Int
    ): MovieDetails

    @GET("search/movie?api_key=${API_KEY}")
    suspend fun getMovieBySearch(
       @Query("query") query: String
    ): MovieList
}

