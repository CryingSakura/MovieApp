package com.example.movieapp_try1.screens.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp_try1.MainActivityViewModel
import com.example.movieapp_try1.screens.Blog
import com.example.movieapp_try1.screens.ComingSoon
import com.example.movieapp_try1.screens.FilmList

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun MainViewNavigationGraph(navController: NavHostController, viewModel: MainActivityViewModel){
    NavHost(navController = navController,
        route = Graphs.MAIN_VIEW,
        startDestination = BottomBarScreens.Blog.route){
        composable(route = BottomBarScreens.Blog.route){
            Blog()
        }
        composable(route = BottomBarScreens.FilmList.route){
            FilmList(navController = navController, viewModel = viewModel)
        }
        composable(route = BottomBarScreens.ComingSoon.route){
            ComingSoon()
        }
        filmListGraph(viewModel = viewModel)





    }
}