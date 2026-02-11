package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ies.murallaromana.coronelhernanproyectopmdp.screens.Login
import ies.murallaromana.coronelhernanproyectopmdp.screens.MovieScreen
import ies.murallaromana.coronelhernanproyectopmdp.screens.MovieList
import ies.murallaromana.coronelhernanproyectopmdp.screens.Register


@Composable
fun AppNavigation(
    modifier: Modifier,
    navController: NavHostController,
    changeSubtitle: (subtitle: String) -> Unit
) {
    val context = LocalContext.current
    val fileName = "movies.json"
    NavHost(navController = navController, startDestination = "movieList") {
        composable("login") {
            changeSubtitle("Login")
            Login(
                modifier = modifier,
                onNavigateToMovieList = {
                    navController.navigate("movieList") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                },
                context = context
            )
        }
        composable("register") {
            changeSubtitle("Registro")
            Register(
                modifier = modifier,
                onNavigateToMovieList = {
                    navController.navigate("movieList") {
                        popUpTo("register") { inclusive = true }
                    }
                },
            )
        }
        composable("movieList") {
            changeSubtitle("Lista de peliculas")
            MovieList(
                modifier = modifier,
                onNavigateToMovie = { movieId: Int ->
                    navController.navigate("movie/$movieId")
                },
                context = context,
                file = fileName
            )
        }
        composable("movie/{movieId}") { backStackEntry ->
            val movieIdString = backStackEntry.arguments?.getString("movieId")

            val movieId = movieIdString?.toIntOrNull() ?: 0

            if (movieId == null) {
                navController.popBackStack()
            } else {
                changeSubtitle("Detalles")
                MovieScreen(
                    modifier = modifier,
                    context = context,
                    movieId = movieId,
                    file = fileName
                )
            }
        }
    }
}