package ies.murallaromana.coronelhernanproyectopmdp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBarTitle(
    imageTitle: Int,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    subtitleModifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(bottom = 2.dp, top = 5.dp, start = 5.dp, end = 5.dp)
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = imageTitle),
            contentDescription = title
        )
        Text(
            text = subtitle,
            modifier = subtitleModifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )
    }
}