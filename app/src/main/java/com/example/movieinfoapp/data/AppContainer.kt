package com.example.movieinfoapp.data

import com.example.movieinfoapp.network.MovieApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val moviesRepository: MoviesRepository
}

class DefaultAppContainer: AppContainer {
    private val baseUrl = "https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory(("application/json".toMediaType())))
        .baseUrl(baseUrl)
        .build()

        private val retrofitService: MovieApiService by lazy {
            retrofit.create(MovieApiService::class.java)
        }

    override val moviesRepository: MoviesRepository by lazy {
        NetworkMoviesRepository(retrofitService)
    }
}