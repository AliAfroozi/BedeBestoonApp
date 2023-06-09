package com.example.bedebestoon.viewmodel.invoice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.invoice.Invoice
import com.example.bedebestoon.repository.invoice.InvoiceRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InvoiceViewModel @Inject constructor(private val invoiceRepo: InvoiceRepo) : ViewModel() {
    fun getInvoiceById(id: Long, onResponse: (ServiceResponse<Invoice>) -> Unit) {
        viewModelScope.launch {
            //Todo : Fix token
            onResponse(invoiceRepo.getInvoiceById(id , ""))
        }
    }

    fun getAllInvoiceByUserId(userId : Long , pageSize: Int , pageIndex: Int , onResponse : (ServiceResponse<Invoice>) -> Unit) {
        viewModelScope.launch {
            //Todo : Fix token
            onResponse(invoiceRepo.getAllInvoicesByUserId(userId , pageSize , pageIndex , ""))
        }
    }

    fun addInvoice(invoice: Invoice , onResponse: (ServiceResponse<Invoice>) -> Unit) {
        viewModelScope.launch {
            //Todo : Fix token
            onResponse(invoiceRepo.addInvoice(invoice , ""))
        }
    }


}