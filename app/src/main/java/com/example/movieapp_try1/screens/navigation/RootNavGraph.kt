package com.example.movieapp_try1.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp_try1.screens.MainView


@Composable
fun RootNavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = Graphs.MAIN_VIEW){
        composable(route = Graphs.MAIN_VIEW){
            MainView()
        }
    }
}