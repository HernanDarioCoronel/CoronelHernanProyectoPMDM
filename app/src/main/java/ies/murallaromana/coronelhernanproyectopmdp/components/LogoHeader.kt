package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ies.murallaromana.coronelhernanproyectopmdp.R

@Composable
fun LogoHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cine_pass_logo),
            contentDescription = "Logo Login",
        )
    }
}