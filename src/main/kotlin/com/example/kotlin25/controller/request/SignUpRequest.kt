package com.example.kotlin25.controller.request

data class SignUpRequest (
    val email: String,
    val password: String,
    val name: String,
)