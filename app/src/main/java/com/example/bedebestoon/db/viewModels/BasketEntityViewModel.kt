package com.example.bedebestoon.db.viewModels

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.db.models.BasketEntity
import com.example.bedebestoon.db.repository.BasketEntityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BasketEntityViewModel(application: Application) : AndroidViewModel(application) {
    private var basketRepository: BasketEntityRepository = BasketEntityRepository(application)
    var basketListLive = mutableStateOf<List<BasketEntity>>(listOf())

    init {
        getBasketListLive()
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


     fun getBasketListLive(): LiveData<List<BasketEntity>> {
             return basketRepository.getBasketListLive()
    }

    fun addToBasket(basketItem: BasketEntity) {
        if (basketListLive.value.any { it.productId == basketItem.productId && it.colorId == basketItem.colorId && it.sizeId == basketItem.sizeId}) {
            var oldBasket = basketListLive.value.first {  it.productId == basketItem.productId && it.colorId == basketItem.colorId && it.sizeId == basketItem.sizeId }
            oldBasket.quantity = oldBasket.quantity + 1
            update(oldBasket)
        } else {
            insert(basketItem)
        }

    }

    fun incrementQuantity(basketEntity: BasketEntity){
        viewModelScope.launch {
            basketRepository.incrementQuantity(basketEntity)
        }
    }

    fun decrementQuantity(basketEntity: BasketEntity){
        viewModelScope.launch {
            basketRepository.decrementQuantity(basketEntity)
        }
    }
}