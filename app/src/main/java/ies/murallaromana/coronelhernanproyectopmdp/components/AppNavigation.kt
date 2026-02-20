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
                context = context,
                file = fileName,
                onNavigateToMovie = { movieId: String ->
                    navController.navigate("movie/$movieId")
                },
                onNavigateToMovieEdit = { movieId: String ->
                    navController.navigate("movie/edit/$movieId")
                }
            )
        }
        composable("movie/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")

            changeSubtitle("Detalles")
            MovieScreen(
                modifier = modifier,
                movieId = movieId,
                file = fileName,
                context = context,
            )
        }
        composable("movie/edit/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")

            changeSubtitle("Editar")
            MovieScreen(
                modifier = modifier,
                context = context,
                movieId = movieId,
                file = fileName,
                isEditing = true,
                onGoBack = {
                    navController.popBackStack()
                }
            )
        }
        composable("movie/add"){backstackEntry -> 
            changeSubtitle("Añadir")
            MovieScreen(
                modifier = modifier,
                context = context,
                file = fileName
            )
        }
    }
}