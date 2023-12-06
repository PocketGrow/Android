package com.example.pocketgrow.api.request

data class RegisterRequest (
    val fullname: String,
    val email: String,
    val password: String,
    val dateOfBirth : String = "2023-01-15T10:30:00Z"
)