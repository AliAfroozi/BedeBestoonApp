package com.example.onlineshopapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.onlineshopapp.db.models.UserEntity

@Dao
interface UserEntityDao {

    @Insert
    suspend fun insert(userEntity: UserEntity)

    @Update
    suspend fun update(userEntity: UserEntity)

    @Query("Delete From UserEntity Where user_id = :userId")
    suspend fun delete(userId : Long)

    @Query("Select * From UserEntity Where user_id = :userId")
    suspend fun getUser(userId : Long) : LiveData<UserEntity>
}