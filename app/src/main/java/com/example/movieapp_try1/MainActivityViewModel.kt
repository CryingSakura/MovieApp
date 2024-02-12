package com.example.movieapp_try1
import androidx.lifecycle.ViewModel
import com.example.movieapp_try1.network.ReqRep
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val requestRepository: ReqRep
): ViewModel() {



}