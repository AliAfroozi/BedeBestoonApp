package com.example.bedebestoon.db.repository

import android.content.Context
import com.example.bedebestoon.db.BedeBestooonDatabase
import com.example.bedebestoon.db.dao.BasketEntityDao
import com.example.bedebestoon.db.models.BasketEntity

class BasketEntityRepository(context : Context) {

    private lateinit var basketEntityDao: BasketEntityDao
    private lateinit var basketList: List<BasketEntity>

    init {
        val db = BedeBestooonDatabase.getInstance(context)
        basketEntityDao = db!!.getBasketDao()
    }

    suspend fun insert(basketEntity: BasketEntity) {
        basketEntityDao.insert(basketEntity)
    }

    suspend fun update(basketEntity: BasketEntity) {
        basketEntityDao.update(basketEntity)
    }

    suspend fun delete(basketEntity : BasketEntity) {
        basketEntityDao.delete(basketEntity)
    }

    suspend fun deleteAll() {
         basketEntityDao.deleteAll()
    }

    suspend fun getBasketList(): List<BasketEntity> {
        basketList = basketEntityDao.getBasketList()
        return basketList
    }


}