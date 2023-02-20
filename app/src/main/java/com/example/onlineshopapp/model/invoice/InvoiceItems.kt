package com.example.onlineshopapp.model.invoice

import com.example.onlineshopapp.model.product.Product

data class InvoiceItems(
    var id : Long?,
    var product : Product?,
    var qauntity : Int?,
    var unitPrice : String?
)
