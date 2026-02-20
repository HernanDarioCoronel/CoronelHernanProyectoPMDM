package ies.murallaromana.coronelhernanproyectopmdp.dataAccess.retrofit

import ies.murallaromana.coronelhernanproyectopmdp.dataAccess.retrofit.DTO.LoginResponse
import ies.murallaromana.coronelhernanproyectopmdp.entities.User
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersApiService {
    @POST("user/signup")
    suspend fun signup(@Body user: User)

    @POST("user/login")
    suspend fun login(@Body user: User): LoginResponse
}