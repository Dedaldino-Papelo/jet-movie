package com.example.movieinfoapp.fake

import com.example.movieinfoapp.data.NetworkMoviesRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMoviesRepositoryTest {
    @Test
    fun networkMoviesRepository_getMovies_verifyMovieList() =
        runTest {
        val repository = NetworkMoviesRepository(
            movieApiService = FakeMovieApiService()
        )
        assertEquals(FakeDataSource.movieList, repository.getMovies())
    }
}