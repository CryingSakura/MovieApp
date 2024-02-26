package com.example.movieapp_try1.data.mappers

import com.example.movieapp_try1.data.local.ResultsEntity
import com.example.movieapp_try1.data.model.Result



/*
fun PopularMovieList.toPopMoviesEntity(): PopMoviesEntity {
    return PopMoviesEntity(
        page, results, total_pages, total_results
    )
}

fun PopMoviesEntity.toPopMovies(): PopularMovieList{
    return PopularMovieList(
        page, results, total_pages, total_results
    )
}
*/

fun Result.toResultEntity(): ResultsEntity{
    return ResultsEntity(
        page,
        adult, backdrop_path, myId, id, original_language, original_title,
        overview, popularity, poster_path, release_date,
        title, video, vote_average, vote_count
    )
}

fun ResultsEntity.toResult(): Result{
    return Result(
        page,
        adult, backdrop_path, myId, id, original_language, original_title, overview,
        popularity, poster_path, release_date, title, video, vote_average, vote_count
    )
}
