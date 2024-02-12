package com.example.movieapp_try1.network
import com.example.movieapp_try1.data.model.MovieModel
import com.example.movieapp_try1.network.services.RequestService
import retrofit2.Response
import javax.inject.Inject

class ReqRep @Inject constructor(
    private val requestService: RequestService
) {

    suspend fun getMovieList(): Response<MovieModel>{
        return requestService.getMovieList()
    }

}