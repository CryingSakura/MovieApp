package com.example.movieapp_try1.screens.navigation
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.movieapp_try1.MainActivityViewModel
import com.example.movieapp_try1.screens.fragments.FilmDetailsScreen


fun NavGraphBuilder.filmListGraph(viewModel: MainActivityViewModel){
    navigation(
        route = Graphs.DETAILS,
        startDestination = CardsGraph.Card.route
    ){
        composable(route = CardsGraph.Card.route){

            FilmDetailsScreen(viewModel = viewModel)

        }
    }
}