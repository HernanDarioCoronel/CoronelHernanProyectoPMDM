package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun TopBar() {
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.primary)) {
        Spacer(modifier = Modifier.padding(32.dp))
        Button(
            onClick = {}
        ) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Menú"
            )
        }
    }
}