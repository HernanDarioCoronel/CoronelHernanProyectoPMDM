package ies.murallaromana.coronelhernanproyectopmdp.dataAccess.json

import android.content.Context
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie
import kotlinx.serialization.json.Json
import java.io.File

object MovieManager {
    private const val DEFAULT_FILE = "movies.json"

    private val jsonConfig = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        isLenient = true
    }

    fun loadMovies(context: Context, fileName: String = DEFAULT_FILE): List<Movie> {
        val internalFile = File(context.filesDir, fileName)
        return try {
            val jsonString = if (internalFile.exists()) {
                internalFile.readText()
            } else {
                context.assets.open(fileName).bufferedReader().use { it.readText() }
            }
            jsonConfig.decodeFromString<List<Movie>>(jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun saveMovies(context: Context, movies: List<Movie>, fileName: String = DEFAULT_FILE) {
        try {
            val jsonString = jsonConfig.encodeToString(movies)
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
                output.write(jsonString.toByteArray())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addMovie(context: Context, movie: Movie, fileName: String = DEFAULT_FILE) {
        val movies = loadMovies(context, fileName).toMutableList()

        val nextId = (movies.maxOfOrNull { it.id.toIntOrNull() ?: 0 } ?: 0) + 1

        val newMovie = movie.copy(id = nextId.toString())

        movies.add(newMovie)
        saveMovies(context, movies, fileName)
    }

    fun editMovie(context: Context, updatedMovie: Movie, fileName: String = DEFAULT_FILE) {
        val movies = loadMovies(context, fileName).map {
            if (it.id == updatedMovie.id) updatedMovie else it
        }
        saveMovies(context, movies, fileName)
    }

    fun deleteMovie(context: Context, id: String, fileName: String = DEFAULT_FILE) {
        val movies = loadMovies(context, fileName).filter { it.id != id }
        saveMovies(context, movies, fileName)
    }

    fun getMovieById(context: Context, id: String, fileName: String = DEFAULT_FILE): Movie? =
        loadMovies(context, fileName).find { it.id == id }
}