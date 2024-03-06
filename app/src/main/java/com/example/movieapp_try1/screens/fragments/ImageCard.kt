@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.movieapp_try1.screens.fragments

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movieapp_try1.MainActivityViewModel
import com.example.movieapp_try1.data.model.Result
import com.example.movieapp_try1.network.services.RequestService.Companion.IMAGE_URL
import com.example.movieapp_try1.screens.navigation.Graphs


@Composable
fun ImageCard (
    movie: Result,
    modifier:Modifier = Modifier,
    fraction: Float = 1f,
    viewModel: MainActivityViewModel,
    navController: NavHostController
    ){


    movie.let { Log.e("GogaResponsezzzz", it.title) }



    val imgUrl = IMAGE_URL + movie.poster_path


    Card(
        modifier = modifier
            .fillMaxWidth(fraction),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        onClick = {
            viewModel.fetchMovieData(movie)
            navController.navigate(Graphs.DETAILS)
        }

        ){

        Box(modifier = modifier
            .height(256.dp)
            .width(200.dp)) {
            AsyncImage(modifier = modifier.fillMaxSize(),
                model = imgUrl,
                contentDescription = movie.title,
                contentScale = ContentScale.FillBounds)


            Box(modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
            )



            Box(modifier = modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart) {
                Text(text = movie.title, style = TextStyle(color = Color.White), fontSize = 16.sp)
            }
        }
    }
}