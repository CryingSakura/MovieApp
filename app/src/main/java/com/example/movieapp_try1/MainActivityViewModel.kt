package com.example.movieapp_try1

import androidx.lifecycle.ViewModel
import com.example.movieapp_try1.network.services.RequestService
import dagger.hilt.android.lifecycle.HiltViewModel


@HiltViewModel
class MainActivityViewModel(
    private val requestService: RequestService
): ViewModel() {



}