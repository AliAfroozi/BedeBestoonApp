package com.example.BedeBestoon.db.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.BedeBestoon.db.models.BasketEntity
import com.example.BedeBestoon.db.repository.BasketEntityRepository
import kotlinx.coroutines.launch

class BasketEntityViewModel(application: Application) : AndroidViewModel(application) {
    private var basketRepository: BasketEntityRepository = BasketEntityRepository(application)
    private var basketList = basketRepository.getBasketListSynchronous()

    fun insert(basketEntity: BasketEntity){
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

    fun getBasketList(response : (List<BasketEntity>) -> Unit){
        viewModelScope.launch {
            response(basketRepository.getBasketList())
        }
    }

    fun getBasketListSynchronous(): List<BasketEntity> {
        return basketList
    }

}