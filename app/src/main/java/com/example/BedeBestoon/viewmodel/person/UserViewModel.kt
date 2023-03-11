package com.example.BedeBestoon.viewmodel.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.person.User
import com.example.BedeBestoon.model.person.UserVM
import com.example.BedeBestoon.repository.person.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepo: UserRepo) : ViewModel() {
    fun getUserByUsername(username: String , onResponse: (ServiceResponse<User>) -> Unit) {
        viewModelScope.launch {
            //Todo : Fix token
            onResponse(userRepo.getUserByUsername(username , ""))
        }
    }

    fun changeUserPassword(userVM: UserVM , onResponse : (ServiceResponse<UserVM>) -> Unit) {
        viewModelScope.launch {
            //Todo : Fix token
            onResponse(userRepo.changeUserPass(userVM , ""))
        }
    }

    fun login(userVM: UserVM , onResponse : (ServiceResponse<UserVM>) -> Unit) {
        viewModelScope.launch {
            onResponse(userRepo.login(userVM))
        }
    }

    fun register(userVM: UserVM , onResponse : (ServiceResponse<User>) -> Unit) {
        viewModelScope.launch {
            onResponse(userRepo.register(userVM))
        }
    }

    fun update(userVM: UserVM , onResponse : (ServiceResponse<User>) -> Unit) {
        viewModelScope.launch {
            //Todo : Fix token
            onResponse(userRepo.update(userVM , ""))
        }
    }


}