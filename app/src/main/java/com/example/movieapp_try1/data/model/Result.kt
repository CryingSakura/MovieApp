package com.example.movieapp_try1.data.model


data class Result(
    var page: Int,
    val adult: Boolean,
    val backdrop_path: String?,
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
    /*  val adult: Boolean = false,
      val backdrop_path: String = "",
      val id: Int = 0,
      val original_language: String = "",
      val original_title: String = "",
      val overview: String = "",
      val popularity: Double = 0.0,
      val poster_path: String = "",
      val release_date: String = "",
      val title: String = "",
      val video: Boolean = false,
      val vote_average: Double = 0.0,
      val vote_count: Int = 0*/
)