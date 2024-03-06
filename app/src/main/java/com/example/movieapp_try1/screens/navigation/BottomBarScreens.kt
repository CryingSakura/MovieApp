package com.example.movieapp_try1.screens.navigation

sealed class BottomBarScreens(
    val route: String
) {
    object Blog: BottomBarScreens(route = Graphs.BLOG)
    object ComingSoon: BottomBarScreens(route = Graphs.COMING_SOON)
    object FilmList: BottomBarScreens(route = Graphs.WATCHLIST)
}