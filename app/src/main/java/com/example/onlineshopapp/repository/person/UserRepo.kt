package com.example.onlineshopapp.repository.person

import com.example.onlineshopapp.api.person.UserApi
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.person.User
import com.example.onlineshopapp.model.person.UserVM
import com.example.onlineshopapp.repository.base.BaseRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserRepo @Inject constructor(private val UserApi: UserApi) : BaseRepository() {

    suspend fun getUserByUsername(
        token: String,
        username: String
    ): ServiceResponse<User> {
        return try {
            UserApi.getUserByUsername(username , prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun changeUserPass(userVM: UserVM, token: String): ServiceResponse<UserVM> {
        return try {
            UserApi.changeUserPass(userVM, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun login(userVM: UserVM): ServiceResponse<UserVM> {
        return try {
            UserApi.login(userVM)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun register(userVM: UserVM): ServiceResponse<User> {
        return try {
            UserApi.register(userVM)
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun update(userVM: UserVM , token: String): ServiceResponse<User> {
        return try {
            UserApi.updateUser(userVM , prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}