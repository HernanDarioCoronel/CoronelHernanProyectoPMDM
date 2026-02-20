package ies.murallaromana.coronelhernanproyectopmdp.dataAccess.retrofit

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object InstanciaRetrofit {
    private const val BASE_URL = "https://moviesrestapi-production.up.railway.app/"

    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json; charset=utf-8".toMediaType()
                )
            )
            .build()
    }

    val moviesApi: MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }

    val usersApi: UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java)
    }
}