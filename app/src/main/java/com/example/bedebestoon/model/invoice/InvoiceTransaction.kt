package com.example.bedebestoon.model.invoice

data class InvoiceTransaction(
    var id: Long?,
    var authority: String?,
    var refId: String?,
    var status: Int?
)
