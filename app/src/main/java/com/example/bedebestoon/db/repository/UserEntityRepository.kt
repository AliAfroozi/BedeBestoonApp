package com.example.bedebestoon.db.repository

import android.content.Context
import com.example.bedebestoon.db.BedeBestooonDatabase
import com.example.bedebestoon.db.dao.UserEntityDao
import com.example.bedebestoon.db.models.UserEntity

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