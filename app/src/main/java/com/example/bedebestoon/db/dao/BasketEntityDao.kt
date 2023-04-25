package com.example.bedebestoon.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bedebestoon.db.models.BasketEntity

@Dao
interface BasketEntityDao {
    
    @Insert
    suspend fun insert(basketEntity: BasketEntity)

    @Update
    suspend fun update(basketEntity: BasketEntity)

    @Delete
    suspend fun delete(basketEntity: BasketEntity)

    @Query("Select * From BasketEntity")
    fun getBasketListLive() : LiveData<List<BasketEntity>>

    @Query("Delete From BasketEntity")
    suspend fun deleteAll()
}