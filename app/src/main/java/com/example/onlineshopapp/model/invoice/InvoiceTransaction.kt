package com.example.onlineshopapp.model.invoice

import java.sql.ClientInfoStatus

data class InvoiceTransaction(
    var id: Long?,
    var authority: String?,
    var refId: String?,
    var status: Int?
)
