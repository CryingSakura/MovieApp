package com.example.movieapp_try1.network.services
import com.example.movieapp_try1.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET


interface RequestService {

    @GET("movie")
    suspend fun getMovieList(
/*        @Query("api_key") apikey: String,
        @Query("page") page: Int,
        @Path("type") type: String*/
    ): Response<MovieModel>

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

}