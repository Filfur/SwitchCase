package com.artemglotov.switchcase.core.models

data class User(
    val userId: Int,
    val email: String,
    val password: String,
    val name: String,
    val steamLink: String,
    val balance: Float
)