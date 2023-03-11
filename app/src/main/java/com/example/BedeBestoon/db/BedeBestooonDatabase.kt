package com.example.BedeBestoon.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.BedeBestoon.db.dao.BasketEntityDao
import com.example.BedeBestoon.db.dao.UserEntityDao
import com.example.BedeBestoon.db.models.BasketEntity
import com.example.BedeBestoon.db.models.UserEntity

@Database(entities = [UserEntity::class , BasketEntity::class] , version = 1)
abstract class BedeBestooonDatabase() : RoomDatabase() {

    abstract fun getUserDao() : UserEntityDao
    abstract fun getBasketDao() : BasketEntityDao

    companion object{
        private val db : BedeBestooonDatabase? = null
        fun getInstance(context : Context): BedeBestooonDatabase? {
            return db
                ?: Room.databaseBuilder(
                    context,
                    BedeBestooonDatabase::class.java, "BedeBestoon.db"
                ).fallbackToDestructiveMigration().build()
        }

    }
}