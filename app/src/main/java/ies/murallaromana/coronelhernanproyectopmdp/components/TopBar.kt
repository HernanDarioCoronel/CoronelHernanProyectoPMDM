package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ies.murallaromana.coronelhernanproyectopmdp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(debugGoBackToLogin: () -> Unit, subtitle: String) {
    TopAppBar(
        title = {
            TopAppBarTitle(
                imageTitle = R.drawable.cine_pass_title,
                title = "MoviePass",
                subtitle = subtitle,
            )
        },
        colors = TopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            scrolledContainerColor = MaterialTheme.colorScheme.secondary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onSecondary,
            actionIconContentColor = Color.Transparent,
            subtitleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationIcon = {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CutCornerShape(0.dp)
                    )

            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menú",
                    modifier = Modifier.size(50.dp)
                )
            }
        },
        actions = {
            IconButton(
                onClick = { debugGoBackToLogin() },
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Usuario",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        expandedHeight = 80.dp
    )
}