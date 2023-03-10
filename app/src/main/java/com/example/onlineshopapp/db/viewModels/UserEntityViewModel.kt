package com.example.onlineshopapp.db.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.onlineshopapp.db.models.UserEntity
import com.example.onlineshopapp.db.repository.UserEntityRepository
import kotlinx.coroutines.launch

class UserEntityViewModel(application: Application) : AndroidViewModel(application) {

    private var userRepository: UserEntityRepository = UserEntityRepository(application)
    private var currentUser = userRepository.getCurrentUser()

    fun insert(userEntity: UserEntity){
        viewModelScope.launch {
            userRepository.insert(userEntity)
        }
    }

    fun update(userEntity: UserEntity){
        viewModelScope.launch {
            userRepository.update(userEntity)
        }
    }

    fun delete(userEntity: UserEntity){
        viewModelScope.launch {
            userRepository.delete(userEntity.userId)
        }
    }


    fun getUser(response : (LiveData<UserEntity>) -> Unit , userEntity: UserEntity){
        viewModelScope.launch {
            response(userRepository.getUser(userEntity.userId))
        }
    }

    fun getCurrentUser(): LiveData<UserEntity> {
        return currentUser
    }
    
}