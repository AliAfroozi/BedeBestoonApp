package com.example.onlineshopapp.db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.onlineshopapp.db.BedeBestooonDatabase
import com.example.onlineshopapp.db.dao.UserEntityDao
import com.example.onlineshopapp.db.models.UserEntity

class UserEntityRepository(context: Context) {
    private lateinit var userEntityDao: UserEntityDao
    private lateinit var currentUser: LiveData<UserEntity>

    init {
        val db = BedeBestooonDatabase.getInstance(context)
        userEntityDao = db!!.getUserDao()
    }

    suspend fun insert(userEntity: UserEntity) {
        delete(userEntity.userId)
        userEntityDao.insert(userEntity)
    }

    suspend fun update(userEntity: UserEntity) {
        userEntityDao.update(userEntity)
    }

    suspend fun delete(userId : Long) {
        userEntityDao.delete(userId)
    }

    suspend fun getUser(userId : Long): LiveData<UserEntity> {
        currentUser = userEntityDao.getUser(userId)
        return currentUser
    }

    fun getCurrentUser(): LiveData<UserEntity> {
        return currentUser
    }
}