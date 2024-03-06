package com.example.movieapp_try1.data.model

import java.io.Serializable


data class Result(
    var page: Int = 0,
    val adult: Boolean = false,
    val backdrop_path: String? = null,
    val myId: Int = 0,
    val id: Int = 0,
    val original_language: String = "",
    val original_title: String = "Originat Test",
    val overview: String = "When a Delta Force special ops mission goes terribly wrong, Air Force drone pilot Reaper has 48 hours to remedy what has devolved into a wild rescue operation. With no weapons and no communication other than the drone above, the ground mission suddenly becomes a full-scale battle when the team is discovered by the enemy.",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "Test",
    val video: Boolean = true,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
) : Serializable