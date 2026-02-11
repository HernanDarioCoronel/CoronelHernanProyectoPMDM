package ies.murallaromana.coronelhernanproyectopmdp.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieScreen(
    modifier: Modifier,
    movieId: Int?,
    file: String,
    context: Context,
    isEditing: Boolean = false
) {
    val movieOriginal = remember(movieId) {
        if (movieId != null) {
            MovieManager.getMovieById(
                context = context,
                id = movieId,
                fileName = file
            )
        } else null
    }

    var title by remember { mutableStateOf(movieOriginal?.title ?: "") }
    var genre by remember { mutableStateOf(movieOriginal?.genre ?: "") }
    var year by remember { mutableStateOf(movieOriginal?.year?.toString() ?: "") }
    var sinopsis by remember { mutableStateOf(movieOriginal?.sinopsis ?: "") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = if (movieId == null) "Nueva Película" else if (isEditing) "Editar Película" else "Detalles",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isEditing || movieId == null) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Text(text = title, style = MaterialTheme.typography.headlineSmall)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            if (isEditing || movieId == null) {
                OutlinedTextField(
                    value = genre,
                    onValueChange = { genre = it },
                    label = { Text("Género") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = year,
                    onValueChange = { year = it },
                    label = { Text("Año") },
                    modifier = Modifier.weight(0.5f)
                )
            } else {
                Text(text = "$genre  •  $year", style = MaterialTheme.typography.bodyLarge)
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        Text(text = "Sinopsis", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        if (isEditing || movieId == null) {
            OutlinedTextField(
                value = sinopsis,
                onValueChange = { sinopsis = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                placeholder = { Text("Escribe el resumen aquí...") }
            )
        } else {
            Text(text = sinopsis, style = MaterialTheme.typography.bodyMedium)
        }

        if (isEditing || movieId == null) {
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    /* saveMovie(title, genre, year.toInt(), sinopsis) */
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (movieId == null) "Crear Película" else "Guardar Cambios")
            }
        }
    }
}