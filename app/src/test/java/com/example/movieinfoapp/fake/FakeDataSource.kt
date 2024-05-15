package com.example.movieinfoapp.fake

import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.model.MovieList

object FakeDataSource {
    val movieList =
        MovieList(
            listOf(
                Movie(
                    adult = false,
                    backdropPath = "/lLh39Th5plbrQgbQ4zyIULsd0Pp.jpg",
                    genreIds = listOf(878, 28, 12),
                    id = 823464,
                    originalLanguage = "en",
                    originalTitle = "Godzilla x Kong: The New Empire",
                    overview = "Following their explosive showdown, Godzilla and Kong must reunite against a colossal undiscovered threat hidden within our world, challenging their very existence – and our own.",
                    popularity = 3384.641,
                    posterPath = "/tMefBSflR6PGQLv7WvFPpKLZkyk.jpg",
                    releaseDate = "2024-03-27",
                    title = "Godzilla x Kong: The New Empire",
                    video = false,
                    voteAverage = 6.94,
                    voteCount = 1346
                ),
                Movie(
                    adult = false,
                    backdropPath = "/fqv8v6AycXKsivp1T5yKtLbGXce.jpg",
                    genreIds = listOf(878, 12, 28),
                    id = 653346,
                    originalLanguage = "en",
                    originalTitle = "Kingdom of the Planet of the Apes",
                    overview = "Several generations in the future following Caesar's reign, apes are now the dominant species and live harmoniously while humans have been reduced to living in the shadows. As a new tyrannical ape leader builds his empire, one young ape undertakes a harrowing journey that will cause him to question all that he has known about the past and to make choices that will define a future for apes and humans alike.",
                    popularity = 2372.67,
                    posterPath = "/gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                    releaseDate = "2024-05-08",
                    title = "Kingdom of the Planet of the Apes",
                    video = false,
                    voteAverage = 7.3,
                    voteCount = 311
                )
            ),
            page = 2,
            totalPages = 10,
            totalResults = 20

        )
}