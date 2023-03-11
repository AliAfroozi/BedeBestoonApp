package com.example.BedeBestoon.db.repository

import android.content.Context
import com.example.BedeBestoon.db.BedeBestooonDatabase
import com.example.BedeBestoon.db.dao.UserEntityDao
import com.example.BedeBestoon.db.models.UserEntity

class UserEntityRepository(context: Context) {
    private lateinit var userEntityDao: UserEntityDao
    private lateinit var currentUser: UserEntity

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

    suspend fun getUser(userId : Long): UserEntity {
        currentUser = userEntityDao.getUser(userId)
        return currentUser
    }

    fun getCurrentUser(): UserEntity {
        return currentUser
    }
}