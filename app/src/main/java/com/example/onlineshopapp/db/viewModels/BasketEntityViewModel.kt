package com.example.onlineshopapp.db.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.onlineshopapp.db.models.BasketEntity
import com.example.onlineshopapp.db.repository.BasketEntityRepository
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

    fun getBasketList(response : (LiveData<List<BasketEntity>>) -> Unit){
        viewModelScope.launch {
            response(basketRepository.getBasketList())
        }
    }

    fun getBasketListSynchronous(): LiveData<List<BasketEntity>> {
        return basketList
    }

}