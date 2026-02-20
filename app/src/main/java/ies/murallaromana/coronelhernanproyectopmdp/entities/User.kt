package ies.murallaromana.coronelhernanproyectopmdp.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
)