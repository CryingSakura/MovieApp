package com.example.movieapp_try1.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp_try1.R
import com.example.movieapp_try1.screens.navigation.Graphs
import com.example.movieapp_try1.screens.navigation.MainViewNavigationGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView(navController: NavHostController = rememberNavController()) {

    /*viewModel.fetchMovieData()*/





    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        Column(modifier = Modifier
                            .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = {
                                navController.navigate(Graphs.WATCHLIST){
                                    popUpTo(Graphs.WATCHLIST)
                                }
                            }) {
                                Icon(modifier = Modifier
                                    .fillMaxSize(),
                                    painter = painterResource(id = R.drawable.ticket_use_light),
                                    contentDescription = "Blog Icon")
                            }
                            Text(text = "WatchList", fontSize = 12.sp)

                        }
                        Column(modifier = Modifier
                            .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = {
                                navController.navigate(Graphs.BLOG){popUpTo(Graphs.BLOG)}
                            }) {
                                Icon(modifier = Modifier
                                    .fillMaxSize(),
                                    painter = painterResource(id = R.drawable.order),
                                    contentDescription = "Blog Icon")
                            }
                            Text(text = "Blog", fontSize = 12.sp)
                        }
                        Column(modifier = Modifier
                            .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = {
                                navController.navigate(Graphs.COMING_SOON){popUpTo(Graphs.COMING_SOON)}
                            }) {
                                Icon(modifier = Modifier
                                    .fillMaxSize(),
                                    painter = painterResource(id = R.drawable.ticket_duotone_line),
                                    contentDescription = "Coming Soon Icon")
                            }
                            Text(text = "Coming Soon", fontSize = 12.sp)
                        }
                    }
                })
        }
    ){
         MainViewNavigationGraph(navController = navController)
    }
}
