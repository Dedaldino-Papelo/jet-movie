package com.example.movieinfoapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.movieinfoapp.R
import com.example.movieinfoapp.ui.screens.DetailScreen
import com.example.movieinfoapp.ui.screens.FavoriteScreen
import com.example.movieinfoapp.ui.screens.HomeScreen
import com.example.movieinfoapp.ui.screens.MovieViewModel
import com.example.movieinfoapp.ui.screens.SearchScreen
import com.example.movieinfoapp.ui.screens.SettingsScreen
import com.example.movieinfoapp.ui.screens.SignInScreen
import com.example.movieinfoapp.ui.screens.SignUpScreen
import com.example.movieinfoapp.ui.screens.SplashScreen

enum class MovieAppScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Details(title = R.string.details),
    Splash(title = R.string.splash),
    SignUp(title = R.string.signup_txt),
    SignIn(title = R.string.login_txt),
    Favorites(title = R.string.favorites),
    Search(title = R.string.search),
    Settings(title = R.string.settings)
}

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieAppBar(
    currentScreen: MovieAppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!(currentScreen.title == R.string.splash ||
                currentScreen.title == R.string.signup_txt ||
                currentScreen.title == R.string.login_txt ||
                currentScreen.title == R.string.app_name)
    ) {

        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = colorResource(R.color.bg_color),
                titleContentColor = colorResource(R.color.white)
            ),
            title = {
                Text(
                    text = stringResource(currentScreen.title)
                )
            },
            modifier = modifier,
            navigationIcon = {
                if (canNavigateBack &&
                    currentScreen.title != R.string.favorites
                    && currentScreen.title != R.string.settings
                    && currentScreen.title != R.string.search
                    && currentScreen.title != R.string.app_name
                ) {

                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = colorResource(R.color.white),
                            contentDescription = null
                        )
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    val movieViewModel: MovieViewModel = viewModel()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MovieAppScreen.valueOf(
        backStackEntry?.destination?.route ?: MovieAppScreen.Home.name
    )

    val items = listOf(
        BottomNavigationItem(title = "Home", icon = Icons.Default.Home),
        BottomNavigationItem(title = "Search", icon = Icons.Default.Search),
        BottomNavigationItem(title = "Favorites", icon = Icons.Filled.Favorite),
        BottomNavigationItem(title = "Settings", icon = Icons.Default.Settings)
    )

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            MovieAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },

        bottomBar = {
            val navigationItemColors = NavigationBarItemDefaults.colors(
                selectedIconColor = colorResource(R.color.button_color),
                selectedTextColor = colorResource(R.color.button_color),
                indicatorColor = colorResource(R.color.auth_bg_color),
                unselectedIconColor = colorResource(R.color.bottom_icon_color),
                unselectedTextColor = colorResource(R.color.bottom_icon_color)
            )

            if (!(currentScreen.title == R.string.splash ||
                        currentScreen.title == R.string.signup_txt ||
                        currentScreen.title == R.string.login_txt ||
                        currentScreen.title == R.string.details)
            ) {

                NavigationBar(
                    containerColor = colorResource(R.color.auth_bg_color)
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.title, navOptions = navOptions {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.id)
                                })
                            },
                            colors = navigationItemColors,
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                            },
                            label = {
                                Text(text = item.title)
                            },
                        )
                    }
                }
            }
        }

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MovieAppScreen.Splash.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(MovieAppScreen.Splash.name) {
                SplashScreen(
                    onButtonClicked = { navController.navigate(MovieAppScreen.SignIn.name) },
                    onSignUpClicked = { navController.navigate(MovieAppScreen.SignUp.name) }
                )
            }

            composable(route = MovieAppScreen.SignIn.name) {
                SignInScreen(
                    onButtonClicked = { navController.navigate(MovieAppScreen.Home.name) }
                )
            }
            composable(route = MovieAppScreen.SignUp.name) {
                SignUpScreen()
            }
            composable(route = MovieAppScreen.Home.name) {
                HomeScreen(
                    onClick = {
                        movieViewModel.setMovie(it)
                        navController.navigate(MovieAppScreen.Details.name)
                    },
                    movieUiState = movieViewModel.movieUiState,
                )
            }
            composable(MovieAppScreen.Details.name) {
                DetailScreen(movie = movieViewModel.movieDetailsUiState)
            }

            composable(MovieAppScreen.Favorites.name) {
                FavoriteScreen()
            }

            composable(MovieAppScreen.Search.name) {
                SearchScreen(
                    value = movieViewModel.searchText,
                    onValueChange = { newValue ->
                        movieViewModel.updateSearchText(newValue)
                        movieViewModel.getMovieBySearch()
                    },
                    movies = movieViewModel.SearchedMoviesState
                )
            }

            composable(MovieAppScreen.Settings.name) {
                SettingsScreen()
            }
        }
    }
}