package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie
import ies.murallaromana.coronelhernanproyectopmdp.screens.ui.theme.backgroundDark

@Preview(showSystemUi = true)
@Composable
fun MovieFilter(
    filterMovies: (searchText: String) -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }

    Column(modifier =
        Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { newValue ->
                searchText = newValue
                filterMovies(newValue)
            },
            colors =  OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                errorContainerColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )},
            label = { Text("Search Movies") },
            singleLine = true
        )
    }
}

fun filterMovies(movies: List<Movie>, searchText: String): List<Movie> {
    val keywords = searchText.split(" ")

    return movies.filter { it ->
        searchText.all { termino ->
            it.title.contains(termino)
                    || it.genre.contains(termino)
                    || it.year.toString().contains(termino)
        }
    }
}