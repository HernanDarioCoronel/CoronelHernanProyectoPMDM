package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun TopAppBarTitle(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    titleModifier: Modifier = Modifier,
    subtitleModifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            modifier = titleModifier
        )
        Text(
            text = subtitle,
            modifier = subtitleModifier,
            fontSize = 16.sp
        )
    }
}