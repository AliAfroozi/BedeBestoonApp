package com.example.bedebestoon.model.invoice

import com.example.bedebestoon.model.product.Product

data class InvoiceItems(
    var id : Long?,
    var product : Product?,
    var qauntity : Int?,
    var unitPrice : String?
)
