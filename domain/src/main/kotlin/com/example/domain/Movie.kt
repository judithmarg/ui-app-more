package com.example.domain

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val title: String,
    val description: String
)
