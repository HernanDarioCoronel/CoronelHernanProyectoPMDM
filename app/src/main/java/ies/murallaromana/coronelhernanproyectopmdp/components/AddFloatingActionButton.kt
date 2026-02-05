package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AddFloatingActionButton(onNavigateToAddMovie:()->Unit){
    FloatingActionButton (
        onClick = {}
    ) {
        Icon(
            ImageVector = Icons.Filled.Add,
            contentDescription = "Agregar Pelicula"
        )
    }
}