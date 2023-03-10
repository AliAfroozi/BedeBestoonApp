package com.example.onlineshopapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.onlineshopapp.db.models.BasketEntity
import com.example.onlineshopapp.db.models.UserEntity

@Dao
interface BasketEntityDao {
    
    @Insert
    suspend fun insert(basketEntity: BasketEntity)

    @Update
    suspend fun update(basketEntity: BasketEntity)

    @Delete
    suspend fun delete(basketEntity: BasketEntity)

    @Query("Select * From BasketEntity")
    suspend fun getBasketList() : LiveData<List<BasketEntity>>

    @Query("Delete From BasketEntity")
    suspend fun deleteAll() : LiveData<List<BasketEntity>>
}