package com.example.bedebestoon.db.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Entity
import com.example.bedebestoon.db.models.UserEntity
import com.example.bedebestoon.db.repository.UserEntityRepository
import kotlinx.coroutines.launch

@Entity
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


    fun getUser(response : (UserEntity) -> Unit , userEntity: UserEntity){
        viewModelScope.launch {
            response(userRepository.getUser(userEntity.userId))
        }
    }

    fun getCurrentUser(): UserEntity {
        return currentUser
    }
    
}