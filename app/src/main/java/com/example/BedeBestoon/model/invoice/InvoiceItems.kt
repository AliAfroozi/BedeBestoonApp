package com.example.BedeBestoon.model.invoice

import com.example.BedeBestoon.model.product.Product

data class InvoiceItems(
    var id : Long?,
    var product : Product?,
    var qauntity : Int?,
    var unitPrice : String?
)
