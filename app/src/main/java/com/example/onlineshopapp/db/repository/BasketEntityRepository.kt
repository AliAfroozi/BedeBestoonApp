package com.example.onlineshopapp.db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.onlineshopapp.db.BedeBestooonDatabase
import com.example.onlineshopapp.db.dao.BasketEntityDao
import com.example.onlineshopapp.db.models.BasketEntity

class BasketEntityRepository(context : Context) {

    private lateinit var basketEntityDao: BasketEntityDao
    private lateinit var basketList: LiveData<List<BasketEntity>>

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

    suspend fun getBasketList(): LiveData<List<BasketEntity>> {
        basketList = basketEntityDao.getBasketList()
        return basketList
    }

    fun getBasketListSynchronous(): LiveData<List<BasketEntity>> {
        return basketList
    }
}