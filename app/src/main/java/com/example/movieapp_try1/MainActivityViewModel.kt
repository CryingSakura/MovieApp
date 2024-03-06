package com.example.movieapp_try1
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.movieapp_try1.data.local.ResultsEntity
import com.example.movieapp_try1.data.mappers.toResult
import com.example.movieapp_try1.data.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
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









    private val _stateResult = MutableStateFlow(Result())
    val stateResult = _stateResult.asStateFlow()








    fun fetchMovieData(dataForDetailScreen: Result) {
        _stateResult.update { it.copy(
            page = dataForDetailScreen.page,
            adult = dataForDetailScreen.adult,
            backdrop_path = dataForDetailScreen.backdrop_path,
            myId = dataForDetailScreen.myId,
            id = dataForDetailScreen.id,
            original_language = dataForDetailScreen.original_language,
            original_title = dataForDetailScreen.original_title,
            overview = dataForDetailScreen.overview,
            popularity = dataForDetailScreen.popularity,
            poster_path = dataForDetailScreen.poster_path,
            release_date = dataForDetailScreen.release_date,
            title = dataForDetailScreen.title,
            video = dataForDetailScreen.video,
            vote_average = dataForDetailScreen.vote_average,
            vote_count = dataForDetailScreen.vote_count) }

        Log.e("GogaFetchLink", stateResult.toString())
    }











}