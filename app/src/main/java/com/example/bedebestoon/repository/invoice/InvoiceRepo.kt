package com.example.bedebestoon.repository.invoice

import com.example.bedebestoon.api.invoice.InvoiceApi
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.invoice.Invoice
import com.example.bedebestoon.repository.base.BaseRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class InvoiceRepo @Inject constructor(private val InvoiceApi: InvoiceApi) : BaseRepository() {


    suspend fun getInvoiceById(id: Long, token: String): ServiceResponse<Invoice> {
        return try {
            InvoiceApi.getInvoiceById(id, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun getAllInvoicesByUserId(
        userId: Long,
        pageSize: Int,
        pageIndex: Int,
        token: String
    ): ServiceResponse<Invoice> {
        return try {
            InvoiceApi.getAllInvoiceByUserId(userId, pageSize, pageIndex, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }

    suspend fun addInvoice(invoice: Invoice, token: String): ServiceResponse<Invoice> {
        return try {
            InvoiceApi.addInvoice(invoice, prepareToken(token))
        } catch (e: Exception) {
            ServiceResponse(status = "EXCEPTION", message = e.message)
        }
    }
}