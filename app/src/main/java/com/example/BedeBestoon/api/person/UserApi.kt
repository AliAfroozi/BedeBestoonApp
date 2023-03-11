package com.example.BedeBestoon.api.person

import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.person.User
import com.example.BedeBestoon.model.person.UserVM
import retrofit2.http.*

interface UserApi {

    @GET("api/user/{username}")
    suspend fun getUserByUsername(@Path("username") username : String, @Header("Authorization") token : String) : ServiceResponse<User>

    @PUT("api/user/changePassword")
    suspend fun changeUserPass(@Body user : UserVM , @Header("Authorization") token: String) : ServiceResponse<UserVM>

    @POST("api/user/login")
    suspend fun login(@Body user  : UserVM) : ServiceResponse<UserVM>

    @POST("api/user/register")
    suspend fun register(@Body user  : UserVM) : ServiceResponse<User>

    @PUT("api/user/update")
    suspend fun updateUser(@Body user  : UserVM  , @Header("Authorization") token: String) : ServiceResponse<User>
}
