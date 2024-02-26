package com.example.movieapp_try1
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.movieapp_try1.data.local.ResultsEntity
import com.example.movieapp_try1.data.mappers.toResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    pager: Pager<Int, ResultsEntity>,
): ViewModel() {



    val moviePagingFlow = pager
        .flow
        .map {pagingData ->
            pagingData.map { it.toResult() }
        }
        .cachedIn(viewModelScope)







/*

    private val _stateResult = MutableStateFlow(Result())
    val stateResult = _stateResult.asStateFlow()

    private val _statePopList = MutableStateFlow(PopularMovieList())
    val statePopList = _statePopList.asStateFlow()
*/





    /*fun fetchMovieData() = viewModelScope.launch {
        val movieResponse = requestRepository.getMovieList()
        *//*_stateResult.update { it.copy(backdrop_path = requestRepository.getMovieList().body()!!.results[0].poster_path) }*//*
        _statePopList.update { it.copy(results = requestRepository.getMovieList().body()!!.results) }
        Log.e("GogaResponse", "${movieResponse.isSuccessful} ${movieResponse.body()}")
        Log.e("GogaResponse", "${movieResponse.isSuccessful} ${movieResponse.body()!!.results.size}")
    }*/










}