package com.example.movieapp_try1.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp_try1.screens.Blog
import com.example.movieapp_try1.screens.ComingSoon
import com.example.movieapp_try1.screens.FilmList
import com.example.movieapp_try1.screens.MainView


@Composable
fun RootNavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = Graphs.MAINVIEW) {
        composable(route = Graphs.MAINVIEW){
            MainView()
        }
    }
}