package com.example.onlineshopapp.repository.base

open class BaseRepository {
    fun prepareToken(token : String) : String {
        return if (token.startsWith("bearer")) {
            "bearer $token"
        } else
            token
    }
}