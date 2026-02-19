package ies.murallaromana.coronelhernanproyectopmdp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ies.murallaromana.coronelhernanproyectopmdp.components.AppNavigation
import ies.murallaromana.coronelhernanproyectopmdp.components.TopBar
import ies.murallaromana.coronelhernanproyectopmdp.screens.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var currentSubtitle by remember { mutableStateOf("Login") }
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            AppTheme {
                Scaffold(
                    floatingActionButton = {
                        val currentRoute = navBackStackEntry?.destination?.route
                        val canPop = navController.previousBackStackEntry != null
                        if (canPop)
                            FloatingActionButton(
                                onClick = { navController.popBackStack() },
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Volver atrás"
                                )
                            }
                        else if (currentRoute == "movieList")
                            FloatingActionButton(
                                onClick = { navController.navigate("movie/add") }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Agregar Pelicula"
                                )
                            }

                    },
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar(
                            subtitle = currentSubtitle,
                            debugGoBackToLogin = {
                                navController.navigate("login") {
                                    popUpTo("movieList") { inclusive = true }
                                }
                            })
                    }
                ) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        changeSubtitle = { currentSubtitle = it }
                    )
                }
            }
        }
    }
}
