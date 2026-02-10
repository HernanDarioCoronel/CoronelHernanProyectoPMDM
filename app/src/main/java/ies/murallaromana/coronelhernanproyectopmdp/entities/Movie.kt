package ies.murallaromana.coronelhernanproyectopmdp.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("id") val id: Int,
    @SerialName("Title") val title: String,
    @SerialName("Genre") val genre: String,
    @SerialName("Sinopsis") val sinopsis: String,
    @SerialName("Year") val year: Int
)
