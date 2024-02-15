package com.example.movieapp_try1
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp_try1.network.ReqRep
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val requestRepository: ReqRep
): ViewModel() {

    private val _state = MutableStateFlow(Try())
    val state = _state.asStateFlow()





    fun fetchMovieData() = viewModelScope.launch {
        val movieResponse = requestRepository.getMovieList()
        _state.update { it.copy(urlImg = requestRepository.getMovieList().body()!!.results[1].backdrop_path) }
        Log.e("GogaResponse", "${movieResponse.isSuccessful} ${movieResponse.body()}")
    }










}