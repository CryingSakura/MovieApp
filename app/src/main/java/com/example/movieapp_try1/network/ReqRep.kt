package com.example.movieapp_try1.network
import com.example.movieapp_try1.data.model.PopularMovieList
import com.example.movieapp_try1.network.services.RequestService
import retrofit2.Response
import javax.inject.Inject

class ReqRep @Inject constructor(
    private val requestService: RequestService
) {

    suspend fun getMovieList(): Response<PopularMovieList>{
        return requestService.getMovieList(1, RequestService.API)
    }

}