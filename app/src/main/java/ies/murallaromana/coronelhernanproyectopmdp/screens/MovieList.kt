package ies.murallaromana.coronelhernanproyectopmdp.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ies.murallaromana.coronelhernanproyectopmdp.components.MovieItem
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie

@Composable
fun MovieList(
    onNavigateToMovie: (movieId: Int) -> Unit,
    onNavigateToMovieEdit: (movieId: Int) -> Unit,
    modifier: Modifier,
    context: Context,
    file: String
) {
    var movies by remember { mutableStateOf(emptyList<Movie>()) }
    var openDialog by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        LaunchedEffect(Unit) {
            movies = MovieManager.loadMovies(context, file)
        }
        if (movies.isEmpty()) {
            Text("Loading movies or file not found...")
        } else {
            LazyColumn {
                items(movies) { movie ->
                    MovieItem(
                        movie = movie,
                        context = context,
                        onNavigateToMovie = onNavigateToMovie,
                        onNavigateToMovieEdit = onNavigateToMovieEdit,
                        onOpenDialog = {}
                    )
                }
            }
            if (openDialog) {
                // igual esto deberia ir en el composable padre?
                BasicAlertDialog(
                    onDismissRequest = {
                        openDialog = false
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight(),
                        shape = MaterialTheme.shapes.large,
                        tonalElevation = AlertDialogDefaults.TonalElevation,
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Estas seguro que quieres eliminar la pelicula?")
                            Spacer(modifier = Modifier.height(24.dp))
                            Row(modifier = Modifier.align(Alignment.End), horizontalArrangement = Arrangement.SpaceBetween) {
                                TextButton(
                                    onClick = {
                                        MovieManager.deleteMovie(id = movie.id, context = context)
                                        openDialog = false
                                    },
                                ) {
                                    Text("Aceptar")
                                }

                                TextButton(
                                    onClick = {
                                        openDialog = false
                                    },
                                ) {
                                    Text("Cancelar")
                                }
                            }

                        }
                    }
                }
            }
        }

    }
}
