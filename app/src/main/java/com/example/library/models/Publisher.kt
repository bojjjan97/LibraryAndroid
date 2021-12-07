package com.example.library.models

import com.example.library.models.Address

data class Publisher(
    val address: Address,
    val description: String,
    val id: String,
    val name: String
)