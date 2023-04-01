package com.example.bedebestoon.model.product

data class Product(
    var id : Long?,
    var addDate : String?,
    var category: ProductCategory?,
    var colors : List<ProductColor>?,
    var description : String?,
    var image : String?,
    var price : String?,
    var sizes : List<ProductSize>?,
    var title : String?,
    var visitCount : Int?
)
