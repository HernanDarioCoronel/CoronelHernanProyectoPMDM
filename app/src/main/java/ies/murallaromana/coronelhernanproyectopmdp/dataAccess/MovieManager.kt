import android.content.Context
import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie
import kotlinx.serialization.json.Json
import java.io.File

object MovieManager {
    private const val DEFAULT_FILE = "movies.json"

    fun loadMovies(context: Context, fileName: String = DEFAULT_FILE): List<Movie> {
        val internalFile = File(context.filesDir, fileName)
        return try {
            val jsonString = if (internalFile.exists()) {
                internalFile.readText()
            } else {
                context.assets.open(fileName).bufferedReader().use { it.readText() }
            }
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun saveMovies(context: Context, movies: List<Movie>, fileName: String = DEFAULT_FILE) {
        val jsonString = Json.encodeToString(movies)
        File(context.filesDir, fileName).writeText(jsonString)
    }

    fun addMovie(context: Context, movie: Movie, fileName: String = DEFAULT_FILE) {
        val movies = loadMovies(context, fileName).toMutableList()
        val nextId = (movies.maxOfOrNull { it.id } ?: -1) + 1
        if (nextId < 1)
            return
        val newMovie = movie.copy(id = nextId)
        movies.add(newMovie)
        val jsonString = Json.encodeToString(movies)
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
            output.write(jsonString.toByteArray())
        }
    }

    fun editMovie(context: Context, updatedMovie: Movie, fileName: String = DEFAULT_FILE) {
        val movies = loadMovies(context, fileName).map {
            if (it.id == updatedMovie.id) updatedMovie else it
        }
        saveMovies(context, movies, fileName)
    }

    fun deleteMovie(context: Context, id: Int, fileName: String = DEFAULT_FILE) {
        val movies = loadMovies(context, fileName).filter { it.id != id }
        saveMovies(context, movies, fileName)
    }

    fun getMovieById(context: Context, id: Int, fileName: String = DEFAULT_FILE): Movie? =
        loadMovies(context, fileName).find { it.id == id }
}