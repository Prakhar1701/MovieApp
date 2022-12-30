package prakhar.udemy.jetpackcompose.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import prakhar.udemy.jetpackcompose.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            //Here we pass where this should lead us to

            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailsScreen.name) {

        }
    }
}