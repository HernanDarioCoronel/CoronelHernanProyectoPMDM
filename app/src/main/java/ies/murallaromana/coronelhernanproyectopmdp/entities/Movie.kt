package ies.murallaromana.coronelhernanproyectopmdp.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Movie(
    @SerialName("id") val id: String,
    @SerialName("Title") val title: String,
    @SerialName("Genre") val genre: String,
    @SerialName("Sinopsis") val sinopsis: String,
    @SerialName("Year") val year: Int
)

/*
@Serializable
data class Movie(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("genre") val genre: String,
    @SerialName("description") val sinopsis: String,
    @SerialName("releaseYear") val year: Int,
    @SerialName("rating") val rating: Double,
    @SerialName("imageUrl") val imageUrl: String,
    @SerialName("directorFullname") val directorName: String,
    @SerialName("runtimeMinutes") val runtime: Int
)
*/
