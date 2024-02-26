/*
package com.example.movieapp_try1.data.converter

import androidx.room.TypeConverter
import com.example.movieapp_try1.data.model.Result
import org.json.JSONArray
import org.json.JSONObject


class ResultsListConverter {


    @TypeConverter
    fun moviesList(results: List<Result>): String {
        return results.toString()
    }

    @TypeConverter
    fun moviesListFromString(resultsString: String): List<Result> {

        val movies = ArrayList<Result>()

        val jsMovie = JSONArray(resultsString)
        for (i in 0 until jsMovie.length()){
            val item = jsMovie[i] as JSONObject
            movies.add(
                Result(
                    adult = item.getBoolean("adult"),
                    backdrop_path = item.getString("backdrop_path"),
                    id = item.getInt("id"),
                    original_language = item.getString("original_language"),
                    original_title = item.getString("original_title"),
                    overview = item.getString("overview"),
                    popularity = item.getDouble("popularity"),
                    poster_path = item.getString("poster_path"),
                    release_date = item.getString("release_date"),
                    title = item.getString("title"),
                    video = item.getBoolean("video"),
                    vote_average = item.getDouble("vote_average"),
                    vote_count = item.getInt("vote_count")

                )
            )
        }
        return movies
    }

}
*/
