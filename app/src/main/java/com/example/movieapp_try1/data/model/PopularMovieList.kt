package com.example.movieapp_try1.data.model

data class PopularMovieList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)