package com.example.movieinfoapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetails(
    val adult: Boolean,
    @SerialName(value = "backdrop_path")
    val backdropPath: String?,
    @SerialName(value = "belongs_to_collection")
    val belongsToCollection: Collection?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Int,
    @SerialName(value = "imdb_id")
    val imdbId: String?,
    @SerialName(value = "origin_country")
    val originCountry: List<String>,
    @SerialName(value = "original_language")
    val originalLanguage: String,
    @SerialName(value = "original_title")
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    @SerialName(value = "poster_path")
    val posterPath: String?,
    @SerialName(value = "production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerialName(value = "production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerialName(value = "release_date")
    val releaseDate: String?,
    val revenue: Int,
    val runtime: Int?,
    @SerialName(value = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    @SerialName(value = "vote_average")
    val voteAverage: Double,
    @SerialName(value = "vote_count")
    val voteCount: Int
)

@Serializable
data class Collection(
    val id: Int,
    val name: String,
    @SerialName(value = "poster_path")
    val posterPath: String?,
    @SerialName(value = "backdrop_path")
    val backdropPath: String?
)

@Serializable
data class Genre(
    val id: Int,
    val name: String
)

@Serializable
data class ProductionCompany(
    val id: Int,
    @SerialName(value = "logo_path")
    val logoPath: String?,
    val name: String,
    @SerialName(value = "origin_country")
    val originCountry: String
)

@Serializable
data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

@Serializable
data class SpokenLanguage(
    @SerialName(value = "english_name")
    val englishName: String,
    val iso_639_1: String,
    val name: String
)
