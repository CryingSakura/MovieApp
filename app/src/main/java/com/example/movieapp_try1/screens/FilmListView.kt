package com.example.movieapp_try1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movieapp_try1.MainActivityViewModel
import com.example.movieapp_try1.R
import com.example.movieapp_try1.screens.fragments.ImageCard

@Preview(showBackground = true)
@Composable
fun FilmList(viewModel: MainActivityViewModel = hiltViewModel()){




    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text(text = "")
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp)) {
            Column(modifier = Modifier
                .weight(1f)) {
                ImageCard(
                    painter = painterResource(id = R.drawable.tryimg), contentDescription = "Img for example",
                    title = "DeadPool")
            }
            Column(modifier = Modifier
                .weight(1f)) {
                ImageCard(
                    painter = painterResource(id = R.drawable.tryimg), contentDescription = "Img for example",
                    title = "DeadPool")
            }
        }
    }
}