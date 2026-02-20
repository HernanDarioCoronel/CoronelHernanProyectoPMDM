package ies.murallaromana.coronelhernanproyectopmdp.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id") val id: String,
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
    @SerialName("firstname") val firstName: String,
    @SerialName("lastName") val lastName: String
)