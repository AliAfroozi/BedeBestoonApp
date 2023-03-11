package com.example.BedeBestoon.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BasketEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "product_id") val productId: Long,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "size_id") val sizeId: Long,
    @ColumnInfo(name = "quantity") val quantity: Int
)