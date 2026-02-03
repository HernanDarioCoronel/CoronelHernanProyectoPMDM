package ies.murallaromana.coronelhernanproyectopmdp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ies.murallaromana.coronelhernanproyectopmdp.components.TopBar
import ies.murallaromana.coronelhernanproyectopmdp.screens.Login
import ies.murallaromana.coronelhernanproyectopmdp.screens.MovieDetails
import ies.murallaromana.coronelhernanproyectopmdp.screens.MovieList
import ies.murallaromana.coronelhernanproyectopmdp.screens.Register
import ies.murallaromana.coronelhernanproyectopmdp.screens.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() }
                ) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Preview
@Composable
fun Preview(){
    MaterialTheme() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopBar() }
        ) { innerPadding ->
            AppNavigation(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            Login(
                modifier = modifier,
                onNavigateToMovieList = {
                    navController.navigate("movieList") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }
        composable("register") {
            Register(
                modifier = modifier,
                onNavigateToMovieList = {
                    navController.navigate("movieList") {
                        popUpTo("register") { inclusive = true }
                    }
                },
                onBackToLogin = { navController.popBackStack() }
            )
        }
        composable("movieList") {
            MovieList(
                modifier = modifier,
                onNavigateToMovieDetails = { movieId: Int ->
                    navController.navigate("novieDetails/$movieId")
                },
                context = context
            )
        }
        composable("movieDetails/{movieId}") {
            MovieDetails(
                modifier = modifier
            )
        }
    }
}