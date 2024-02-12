package com.example.movieapp_try1.screens.navigation

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.movieapp_try1.R

sealed class BottomBarScreens(
    val route: String
) {
    object Blog: BottomBarScreens(route = Graphs.BLOG)
    object ComingSoon: BottomBarScreens(route = Graphs.BLOG)
    object FilmList: BottomBarScreens(route = Graphs.BLOG)
}