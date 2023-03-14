package com.example.bedebestoon.api.invoice

import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.invoice.Invoice
import retrofit2.http.*

interface InvoiceApi {
    @GET("/api/invoice/{invoiceId}")
    suspend fun getInvoiceById(
        @Path("invoiceId") invoiceId: Long,
        @Header("Authorization") token: String
    ): ServiceResponse<Invoice>

    @GET("/api/invoice/user/{userId}")
    suspend fun getAllInvoiceByUserId(
        @Path("userId") userId: Long,
        @Query("pageSize") pageSize: Int,
        @Query("pageIndex") pageIndex: Int,
        @Header("Authorization") token: String
    ): ServiceResponse<Invoice>

    @POST("/api/invoice")
    suspend fun addInvoice(
        @Body invoice: Invoice,
        @Header("Authorization") token: String
    ): ServiceResponse<Invoice>
}