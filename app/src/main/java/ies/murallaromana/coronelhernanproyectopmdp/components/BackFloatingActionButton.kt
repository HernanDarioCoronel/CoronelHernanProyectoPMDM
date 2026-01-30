package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun BackFloatingActionButton(onBack: () -> Unit) {
    FloatingActionButton(
        onClick = onBack
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Volver atrás"
        )
    }
}