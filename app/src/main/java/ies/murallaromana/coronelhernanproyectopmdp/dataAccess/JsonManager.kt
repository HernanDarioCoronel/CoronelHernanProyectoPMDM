package ies.murallaromana.coronelhernanproyectopmdp.dataAccess

import android.content.Context
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie
import kotlinx.serialization.json.Json

fun loadMoviesFromAssets(context: Context, file: String): List<Movie> {
    try {
        val jsonString = context.assets.open(file)
            .bufferedReader()
            .use { it.readText() }

        return Json.decodeFromString<List<Movie>>(jsonString)
    } catch (e: Exception) {
        e.printStackTrace()
        return emptyList()
    }
}