package com.example.bedebestoon.model

class ServiceResponse <T> (
    var data: List<T>? = null,
    var message: String? = null,
    var status: String? = null,
    var totalCount : Long? = null
)