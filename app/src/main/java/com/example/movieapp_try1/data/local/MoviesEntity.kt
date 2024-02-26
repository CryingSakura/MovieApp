package com.example.movieapp_try1.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ResultsEntity(
    val page: Int,
    val adult: Boolean,
    val backdrop_path: String?,
    @PrimaryKey(true)
    val myId: Int,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)



/*

@Entity
data class PopMoviesEntity(
    @PrimaryKey
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
*/
