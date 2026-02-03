package ies.murallaromana.coronelhernanproyectopmdp.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import ies.murallaromana.coronelhernanproyectopmdp.dataAccess.loadMoviesFromAssets
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie

@Composable
fun MovieList(onNavigateToMovieDetails: (movieId: Int) -> Unit, modifier: Modifier, context: Context) {

    var movies by remember { mutableStateOf(emptyList<Movie>()) }

    LaunchedEffect(Unit) {
        movies = loadMoviesFromAssets(context, "movies.json")
    }
    Text("Movie list")
    LazyColumn {
        items(movies) { movie ->
            Text(text = movie.title)
        }
    }
}
