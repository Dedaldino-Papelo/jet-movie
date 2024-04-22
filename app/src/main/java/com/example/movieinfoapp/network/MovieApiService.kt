package com.example.movieinfoapp.network

import com.example.movieinfoapp.model.MovieDetails
import com.example.movieinfoapp.model.MovieList
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://api.themoviedb.org/3/movie/"
private const val API_KEY = "0646faef692c8a46d47607d23054b375"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(("application/json".toMediaType())))
    .baseUrl(BASE_URL)
    .build()
interface MovieApiService {
    @GET("popular?api_key=${API_KEY}")
    suspend fun getMovies(): MovieList

    @GET("{movie_id}?api_key=${API_KEY}")
    suspend fun getMovieById(@Path("movie_id")id: Int): MovieDetails
}

object MovieApi{
    val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}