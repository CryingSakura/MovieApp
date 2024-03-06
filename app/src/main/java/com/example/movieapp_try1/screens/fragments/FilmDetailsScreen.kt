package com.example.movieapp_try1.screens.fragments

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp_try1.MainActivityViewModel
import com.example.movieapp_try1.network.services.RequestService

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FilmDetailsScreen(viewModel: MainActivityViewModel){



    val movie = viewModel.stateResult.value

    Log.e("GogaTryValueLink", viewModel.stateResult.toString())


    val imgUrl = RequestService.IMAGE_URL + movie.poster_path


    /*ABOBA*/


    Box (modifier = Modifier.fillMaxSize())
    {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                AsyncImage(
                    modifier = Modifier
                        .height(256.dp)
                        .width(200.dp),
                    model = imgUrl,
                    contentDescription = movie.title
                )

                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = movie.title)
                    Text(text = movie.original_title)
                }

                Text(text = movie.overview)

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Card {
                        Text(text = movie.popularity.toInt().toString())
                    }
                    Card {
                        Text(text = movie.vote_average.toString())
                    }


                }

            }
    }
}