package com.example.movieapp_try1.di.modules

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.movieapp_try1.data.local.MovieDatabase
import com.example.movieapp_try1.data.local.ResultsEntity
import com.example.movieapp_try1.data.remote.MovieRemoteMediator
import com.example.movieapp_try1.network.services.RequestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
class NetWorkingModule {




    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase{
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "poplist7.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(): RequestService{
        return Retrofit.Builder().baseUrl(RequestService.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create()
    }

    /*@Provides
    fun providesRequestService(retrofit: Retrofit): RequestService{
        return retrofit.create(RequestService::class.java)
    }*/

    @Provides
    @Singleton
    fun provideMoviePager(movieDb: MovieDatabase, movieApi: RequestService): Pager<Int, ResultsEntity>{
        return Pager(
            config = PagingConfig(20),
            remoteMediator = MovieRemoteMediator(
                movieDb = movieDb,
                movieApi = movieApi,
            ),
            pagingSourceFactory = {
                movieDb.dao.pagingSource()
            },
        )
    }


}