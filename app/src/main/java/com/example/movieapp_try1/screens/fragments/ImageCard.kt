package com.example.movieapp_try1.screens.fragments

import android.annotation.SuppressLint
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.movieapp_try1.MainActivityViewModel
import com.example.movieapp_try1.network.services.RequestService.Companion.IMAGE_URL


@SuppressLint("CoroutineCreationDuringComposition", "StateFlowValueCalledInComposition")
@Composable
fun ImageCard (
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier:Modifier = Modifier,
    fraction: Float = 1f,
    weight: Float = 1f,
    viewModel: MainActivityViewModel = hiltViewModel()


    ){


    viewModel.fetchMovieData()

    val urlState = viewModel.state.collectAsState().value.urlImg


    val imgUrl = IMAGE_URL + urlState

    Log.e("GogaUrlResponse", urlState)

    Card (modifier = modifier
        .fillMaxWidth(fraction),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Box(modifier = modifier
            .height(256.dp)
            .width(200.dp)) {
            AsyncImage(model = imgUrl/*IMAGE_URL + "/zVMyvNowgbsBAL6O6esWfRpAcOb.jpg"*/,
                contentDescription = "Example",
                contentScale = ContentScale.FillBounds)
           /* Image(modifier = modifier.fillMaxSize(),
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.FillBounds)*/

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
                Text(text = title, style = TextStyle(color = Color.White), fontSize = 16.sp)
            }
        }
    }
}