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
import ies.murallaromana.coronelhernanproyectopmdp.components.MovieItem
import ies.murallaromana.coronelhernanproyectopmdp.dataAccess.loadMoviesFromAssets
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie

@Composable
fun MovieList(
    onNavigateToMovieDetails: (movieId: Int) -> Unit,
    modifier: Modifier,
    context: Context,
    file: String
) {
    var movies by remember { mutableStateOf(emptyList<Movie>()) }
    Column(modifier = modifier) {
        LaunchedEffect(Unit) {
            movies = loadMoviesFromAssets(context, file)
        }
        Text("Movie list")
        if (movies.isEmpty()) {
            Text("Loading movies or file not found...")
        } else {
            LazyColumn {
                items(movies) { movie ->
                    MovieItem(movie, onNavigateToMovieDetails)
                }
            }
        }

    }
}
