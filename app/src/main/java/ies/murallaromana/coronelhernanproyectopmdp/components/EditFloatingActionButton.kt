package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun EditFloatingActionButton(onNavigateToEditMovie: () -> Unit) {
    FloatingActionButton(
        onClick = {onNavigateToEditMovie()}
    ) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "Editar Pelicula"
        )
    }
}