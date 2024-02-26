package com.example.movieapp_try1.screens

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.movieapp_try1.MainActivityViewModel
import com.example.movieapp_try1.screens.fragments.ImageCard










@SuppressLint("StateFlowValueCalledInComposition")
@Preview(showBackground = true)
@Composable
fun FilmList(viewModel: MainActivityViewModel = hiltViewModel()){

    /*viewModel.fetchMovieData()*/

   /* val popListSize = viewModel.statePopList.collectAsState().value.results.size*/
    /*val popList = viewModel.statePopList.collectAsState().value.results*/

    val movies = viewModel.moviePagingFlow.collectAsLazyPagingItems()







    /*Log.e("GogaUrlResponse", popListSize.toString())*/

    val context = LocalContext.current
    LaunchedEffect(key1 = movies.loadState){
        if (movies.loadState.refresh is LoadState.Error){
            Toast.makeText(context,
                "Error: " + (movies.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_SHORT).show()
        }
    }


    Box (modifier = Modifier
        .fillMaxSize()){
        Log.e("GogaLoadState", LoadState.Loading.toString())
        if (movies.loadState.refresh is LoadState.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            LazyVerticalStaggeredGrid(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),

                )
            {
                items(movies.itemCount){ index->
                    val res = movies[index]
                    Log.e("Gogaaaaaaaaaaaa", "${index}")
                    Column(modifier = Modifier
                        .padding(vertical = 4.dp)) {
                        ImageCard(movie = res)
                    }

                    }
                item {
                    if (movies.loadState.refresh is LoadState.Loading){
                        CircularProgressIndicator()
                    }
                }
                }


            }
        }

    }





/*
    }
}*/
