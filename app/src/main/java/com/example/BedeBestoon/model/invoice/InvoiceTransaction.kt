package com.example.BedeBestoon.model.invoice

data class InvoiceTransaction(
    var id: Long?,
    var authority: String?,
    var refId: String?,
    var status: Int?
)
