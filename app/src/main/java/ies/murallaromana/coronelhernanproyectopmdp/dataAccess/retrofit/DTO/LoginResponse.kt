package ies.murallaromana.coronelhernanproyectopmdp.dataAccess.retrofit.DTO

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String
)