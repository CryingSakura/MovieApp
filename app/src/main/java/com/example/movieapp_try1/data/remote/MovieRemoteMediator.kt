package com.example.movieapp_try1.data.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.movieapp_try1.data.local.MovieDatabase
import com.example.movieapp_try1.data.local.ResultsEntity
import com.example.movieapp_try1.data.mappers.toResultEntity
import com.example.movieapp_try1.network.services.RequestService
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MovieRemoteMediator(
    private val movieDb: MovieDatabase,
    private val movieApi: RequestService,
): RemoteMediator<Int, ResultsEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ResultsEntity>,
    ): MediatorResult {


        return try {
            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null){
                        1
                    }else{
                        lastItem.page.plus(1)
                    }
                }
            }

            val movies = movieApi.getMovieList(page = loadKey, apikey = RequestService.API)





            val result = movies.results
            result.forEach{
                it.page = movies.page
            }

            Log.e("GogaResponse", "${movies.results}")

            movieDb.withTransaction {
                if (loadType == LoadType.REFRESH){
                    movieDb.dao.clearAll()
                }

                val moviesEntities = result.map { it.toResultEntity() }

                Log.e("GogaAAAAAAAAAAA1111", "${moviesEntities}" )
                movieDb.dao.upsertAll(moviesEntities)
            }

            MediatorResult.Success(endOfPaginationReached = (movies.page > 500))
        }catch (e: IOException){
            MediatorResult.Error(e)
        }catch (e: HttpException){
            MediatorResult.Error(e)
        }
    }

}
