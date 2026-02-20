package ies.murallaromana.coronelhernanproyectopmdp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ies.murallaromana.coronelhernanproyectopmdp.R
import ies.murallaromana.coronelhernanproyectopmdp.dataAccess.MovieManager
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie

/**
 * Pantalla de detalle de película que permite visualización, creación y edición.
 *
 * @param modifier Modificador para ajustar el diseño desde el componente superior.
 * @param movieId ID de la película a cargar. Si es nulo, la pantalla entra en modo "Crear".
 * @param file Nombre del archivo o recurso donde se gestionan los datos.
 * @param context Contexto de la aplicación necesario para el [ies.murallaromana.coronelhernanproyectopmdp.dataAccess.MovieManager].
 * @param isEditing Booleano que determina si los campos son editables (modo edición).
 * @param onGoBack Callback que se ejecuta tras guardar los cambios o crear la película.
 */
@Composable
fun MovieScreen(
    modifier: Modifier,
    movieId: Int? = null,
    file: String,
    context: Context,
    isEditing: Boolean = false,
    onGoBack: () -> Unit = {}
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

    val isYearError = !isYearValid(year)
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Poster",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {

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
                        isError = isYearError,
                        supportingText = {
                            if (isYearError) {
                                Text(
                                    text = "Año inválido",
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                        },
                        onValueChange = { newValue ->
                            year = newValue
                        },
                        label = { Text("Año") },
                        modifier = Modifier.weight(0.5f),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true
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
                        if (!isYearError) {
                            if (isEditing)
                                MovieManager.editMovie(
                                    context = context,
                                    updatedMovie = Movie(
                                        id = movieOriginal!!.id,
                                        title = title,
                                        genre = genre,
                                        sinopsis = sinopsis,
                                        year = year.toInt()
                                    )
                                ) else {
                                MovieManager.addMovie(
                                    context = context,
                                    movie = Movie(
                                        id = -1,
                                        title = title,
                                        genre = genre,
                                        sinopsis = sinopsis,
                                        year = year.toInt()
                                    )
                                )
                            }
                            onGoBack()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = if (movieId == null) "Crear Película" else "Guardar Cambios")
                }
            }
        }
    }
}

fun isYearValid(year: String): Boolean {
    return year.all { it.isDigit() } && year.length == 4
}
