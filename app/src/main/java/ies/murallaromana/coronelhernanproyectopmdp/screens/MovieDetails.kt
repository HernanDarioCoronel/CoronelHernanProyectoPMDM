package ies.murallaromana.coronelhernanproyectopmdp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ies.murallaromana.coronelhernanproyectopmdp.R
import ies.murallaromana.coronelhernanproyectopmdp.dataAccess.getMovieByIdFromAssets

@Composable
fun MovieDetails(modifier: Modifier, movieId: Int, file: String, context: Context) {
    var movie = getMovieByIdFromAssets(
        context = context,
        file = file,
        id = movieId
    )!!
    // Asumo que existe ya que lo validé antes de navegar aquí
    Column(modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = movie.title
        )
        Text(
            text = movie.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
