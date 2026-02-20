package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
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
        actions = {
            IconButton(
                onClick = { debugGoBackToLogin() },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "Usuario",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(5.dp).size(50.dp)
                )
            }
        },
        expandedHeight = 80.dp
    )
}