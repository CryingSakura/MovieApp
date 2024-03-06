package com.example.movieapp_try1.screens.navigation

sealed class CardsGraph (val route: String){
    object Card: CardsGraph(route = Graphs.CARD_PAGE)
}