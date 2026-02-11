package ies.murallaromana.coronelhernanproyectopmdp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ies.murallaromana.coronelhernanproyectopmdp.R
import ies.murallaromana.coronelhernanproyectopmdp.dataAccess.getMovieByIdFromAssets

@Composable
fun MovieScreen(modifier: Modifier, movieId: Int, file: String, context: Context) {
    val movie = getMovieByIdFromAssets(
        context = context,
        file = file,
        id = movieId
    )!!

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Poster de ${movie.title}",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = movie.title,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 32.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = movie.genre,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
                Text(text = "  •  ")
                Text(text = movie.year.toString())
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

            Text(
                text = "Sinopsis",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = movie.sinopsis,
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
