package com.example.bedebestoon.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bedebestoon.model.product.ProductSize

@Entity
data class BasketEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "product_id") val productId: Long,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "size_id") val sizeId: Long,
    @ColumnInfo(name = "quantity") var quantity: Int,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "title") val title: String
)