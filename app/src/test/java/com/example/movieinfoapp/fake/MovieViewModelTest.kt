package com.example.movieinfoapp.fake

import com.example.movieinfoapp.rules.TestDispatcherRule
import com.example.movieinfoapp.ui.screens.MovieUiState
import com.example.movieinfoapp.ui.screens.MovieViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class MovieViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun movieViewModel_getMovies_verifyMovieUiStateSuccess() =
        runTest {
            val movieViewModel = MovieViewModel(moviesRepository = FakeNetworkMoviesRepository())
            Assert.assertEquals(
                MovieUiState.Success(FakeDataSource.movieList.results),
                movieViewModel.movieUiState
            )
        }
}