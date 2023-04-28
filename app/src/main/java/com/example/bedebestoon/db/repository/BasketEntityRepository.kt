package com.example.bedebestoon.db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.bedebestoon.db.BedeBestooonDatabase
import com.example.bedebestoon.db.dao.BasketEntityDao
import com.example.bedebestoon.db.models.BasketEntity

class BasketEntityRepository(context : Context) {

    private lateinit var basketEntityDao: BasketEntityDao
    private lateinit var basketList: List<BasketEntity>
    private lateinit var basketListLive: LiveData<List<BasketEntity>>

    init {
        val db = BedeBestooonDatabase.getInstance(context)
        basketEntityDao = db!!.getBasketDao()
        getBasketListLive()
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

     fun getBasketListLive(): LiveData<List<BasketEntity>> {
        basketListLive = basketEntityDao.getBasketListLive()
        return basketListLive
    }

     suspend fun incrementQuantity(basketEntity: BasketEntity) {
        basketEntity.quantity++
        basketEntityDao.update(basketEntity)
    }

    suspend fun decrementQuantity(basketEntity: BasketEntity) {
        if (basketEntity.quantity == 1) {
            basketEntityDao.delete(basketEntity)
        } else {
            basketEntity.quantity--
            basketEntityDao.update(basketEntity)
        }
    }


}