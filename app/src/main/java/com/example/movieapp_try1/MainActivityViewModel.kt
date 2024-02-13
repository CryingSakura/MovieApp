package com.example.movieapp_try1
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp_try1.network.ReqRep
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val requestRepository: ReqRep
): ViewModel() {

    fun fetchMovieData() = viewModelScope.launch {
        val movieResponse = requestRepository.getMovieList()
        Log.e("GogaResponse", "${movieResponse.isSuccessful} ${movieResponse.body()}")
    }



}