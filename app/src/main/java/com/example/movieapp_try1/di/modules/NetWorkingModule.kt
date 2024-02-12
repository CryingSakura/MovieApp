package com.example.movieapp_try1.di.modules

import com.example.movieapp_try1.network.services.RequestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class NetWorkingModule {


    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(RequestService.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun providesRequestService(retrofit: Retrofit): RequestService{
        return retrofit.create(RequestService::class.java)
    }

}