package ies.murallaromana.coronelhernanproyectopmdp.dataAccess.retrofit

import retrofit2.http.POST

interface UsersApiService {
    @POST("api/v1/user/signup")
    suspend fun signup()
}