package com.example.onlineshopapp.model.person

data class UserVM(
    var id: Long?,
    var userName: String?,
    var password: String?,
    var repeatPass: String?,
    var oldPassword: String?,
    var personId: Long?,
    var firstName: String?,
    var lastName: String?,
    var address: String?,
    var phone: String?,
    var postalCode: String?,
    var token: String?
)