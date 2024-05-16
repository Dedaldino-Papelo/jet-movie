package com.example.movieinfoapp.fake

import com.example.movieinfoapp.model.Collection
import com.example.movieinfoapp.model.Genre
import com.example.movieinfoapp.model.Movie
import com.example.movieinfoapp.model.MovieDetails
import com.example.movieinfoapp.model.MovieList
import com.example.movieinfoapp.model.ProductionCompany
import com.example.movieinfoapp.model.ProductionCountry
import com.example.movieinfoapp.model.SpokenLanguage

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

    val movieDetails =
        MovieDetails(
            adult = false,
            backdropPath = "/qrGtVFxaD8c7et0jUtaYhyTzzPg.jpg",
            belongsToCollection =
            Collection(
                id = 1280074,
                name = "Kong Collection",
                posterPath = "/lhyEUeOihbKf7ll8RCIE5CHTie3.jpg",
                backdropPath = "/qHY4ZMIDSmElhiykjhh40Q5qMJl.jpg"
            ),
            budget = 150000000,
            genres = listOf(Genre(id = 878, name = "Science Fiction")),
            homepage = "https://www.godzillaxkongmovie.com",
            id = 823464,
            imdbId = "tt14539740",
            originCountry = listOf("US"),
            originalLanguage = "en",
            originalTitle = "Godzilla x Kong: The New Empire",
            overview = "Following their explosive showdown, Godzilla and Kong must reunite against a colossal undiscovered threat hidden within our world, challenging their very existence – and our own.",
            popularity = 4738.497,
            posterPath = "/tMefBSflR6PGQLv7WvFPpKLZkyk.jpg",
            productionCompanies = listOf(
                ProductionCompany(
                    id = 923,
                    logoPath = "/8M99Dkt23MjQMTTWukq4m5XsEuo.png",
                    name = "Legendary Pictures",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                ProductionCountry(
                    iso_3166_1 = "US",
                    name = "United States of America"
                )
            ),
            releaseDate = "2024-03-27",
            revenue = 558503756,
            runtime = 115,
            spokenLanguages = listOf(
                SpokenLanguage(
                    englishName = "English",
                    iso_639_1 = "en",
                    name = "English"
                )
            ),
            status = "Released",
            tagline = "Rise together or fall alone.",
            title = "Godzilla x Kong: The New Empire",
            video = false,
            voteAverage = 7.037,
            voteCount = 1458
        )
}