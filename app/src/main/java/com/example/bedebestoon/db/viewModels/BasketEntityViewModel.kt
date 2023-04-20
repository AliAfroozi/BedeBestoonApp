package com.example.bedebestoon.db.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.db.models.BasketEntity
import com.example.bedebestoon.db.repository.BasketEntityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class BasketEntityViewModel(application: Application) : AndroidViewModel(application) {
    private var basketRepository: BasketEntityRepository = BasketEntityRepository(application)
    private lateinit var baskListValue : List<BasketEntity>

    init {
        getBasketList()
    }

    private fun insert(basketEntity: BasketEntity){
        viewModelScope.launch {
            basketRepository.insert(basketEntity)
        }
    }

    fun update(basketEntity: BasketEntity){
        viewModelScope.launch {
            basketRepository.update(basketEntity)
        }
    }

    fun delete(basketEntity: BasketEntity){
        viewModelScope.launch {
            basketRepository.delete(basketEntity)
        }
    }

    fun deleteAll(){
        viewModelScope.launch {
            basketRepository.deleteAll()
        }
    }

    private fun getBasketList()  {
        viewModelScope.launch(Dispatchers.IO) {
            baskListValue = basketRepository.getBasketList()
        }
    }

    fun addToBasket(basketItem: BasketEntity) {
        getBasketList()
        if (baskListValue.any { it.productId == basketItem.productId && it.colorId == basketItem.colorId && it.sizeId == basketItem.sizeId}) {
            var oldBasket = baskListValue.first {  it.productId == basketItem.productId && it.colorId == basketItem.colorId && it.sizeId == basketItem.sizeId }
            oldBasket.quantity = oldBasket.quantity + 1
            update(oldBasket)
        } else {
            insert(basketItem)
        }

    }
}