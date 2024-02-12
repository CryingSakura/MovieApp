package com.example.movieapp_try1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.movieapp_try1.screens.MainView
import com.example.movieapp_try1.screens.navigation.RootNavigationGraph
import com.example.movieapp_try1.ui.theme.MovieApp_try1Theme
import com.example.movieapp_try1.ui.theme.RaisinBlack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp_try1Theme {
                Surface(modifier = Modifier.background(color = RaisinBlack)) {
                    RootNavigationGraph(navController = rememberNavController())
                }
            }
        }
    }
}

