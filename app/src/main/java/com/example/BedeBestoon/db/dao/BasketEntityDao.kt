package com.example.BedeBestoon.db.dao

import androidx.room.*
import com.example.BedeBestoon.db.models.BasketEntity

@Dao
interface BasketEntityDao {
    
    @Insert
    suspend fun insert(basketEntity: BasketEntity)

    @Update
    suspend fun update(basketEntity: BasketEntity)

    @Delete
    suspend fun delete(basketEntity: BasketEntity)

    @Query("Select * From BasketEntity")
    suspend fun getBasketList() : List<BasketEntity>

    @Query("Delete From BasketEntity")
    suspend fun deleteAll()
}