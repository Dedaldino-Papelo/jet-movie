package com.example.movieinfoapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieinfoapp.R
import com.example.movieinfoapp.ui.screens.HomeScreen

enum class MovieAppScreen(@StringRes val title: Int){
    Start(title = R.string.app_name),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieAppBar(modifier: Modifier = Modifier){
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            MovieAppBar()
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MovieAppScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = MovieAppScreen.Start.name) {
                HomeScreen()
            }
        }
    }
}