package com.example.movieinfoapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
    val page: Int,
    val total_pages: Int,
    val total_results: Int
)
