package ies.murallaromana.coronelhernanproyectopmdp.dataAccess.retrofit

import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie
import retrofit2.http.GET

interface MoviesApiService {
    @GET("api/v1/movies")
    suspend fun getAllMovies(): List<Movie>
}