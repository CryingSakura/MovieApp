package com.example.movieapp_try1.network.services
import com.example.movieapp_try1.data.model.PopularMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RequestService {

    @GET("movie/popular")
    suspend fun getMovieList(
        /*@Path("movie_id") movie_id: Int,*/
        @Query("page") page: Int,
        @Query("api_key") apikey: String


/*        @Query("query") query: String,

        */
    ): Response<PopularMovieList>

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API = "baa4c8f60cd56f6255a334b048ad6518"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original"
    }



}