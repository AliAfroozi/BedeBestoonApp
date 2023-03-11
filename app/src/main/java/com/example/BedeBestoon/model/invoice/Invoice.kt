package com.example.BedeBestoon.model.invoice

import com.example.BedeBestoon.model.person.User

data class Invoice(
    var id : Long?,
    var status : String?,
    var addDate : String?,
    var invoiceItems : List<InvoiceItems>?,
    var paymentDate : String?,
    var transactionList : List<InvoiceTransaction>?,
    var user : User?
)
