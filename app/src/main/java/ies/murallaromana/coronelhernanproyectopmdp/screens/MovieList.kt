package ies.murallaromana.coronelhernanproyectopmdp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieList(onNavigateToMovieDetails: (movieId: Int) -> Unit, modifier: Modifier) {
    Column(modifier) {
        Text("Movie List")
    }
}
