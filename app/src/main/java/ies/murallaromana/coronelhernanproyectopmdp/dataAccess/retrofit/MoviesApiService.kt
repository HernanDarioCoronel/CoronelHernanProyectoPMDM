package ies.murallaromana.coronelhernanproyectopmdp.dataAccess.retrofit

import ies.murallaromana.coronelhernanproyectopmdp.entities.Movie
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MoviesApiService {
    @GET("movies")
    suspend fun getAllMovies(): List<Movie>

    @GET("movies/{id}")
    suspend fun getById(@Path("id") id: String)

    @POST("movies")
    suspend fun create(@Body movie: Movie)

    @PUT("movies")
    suspend fun update(@Body movie: Movie)

    @DELETE("movies")
    suspend fun delete(@Body movie: Movie)
}