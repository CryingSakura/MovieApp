package com.example.movieapp_try1.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp_try1.screens.Blog
import com.example.movieapp_try1.screens.ComingSoon
import com.example.movieapp_try1.screens.FilmList

@Composable
fun MainViewNavigationGraph(navController: NavHostController){
    NavHost(navController = navController,
        route = Graphs.MAINVIEW,
        startDestination = Graphs.BLOG){
        composable(route = Graphs.BLOG){
            Blog()

        }
        composable(route = Graphs.WATCHLIST){
            FilmList()
        }
        composable(route = Graphs.COMING_SOON){
            ComingSoon()
        }
    }
}