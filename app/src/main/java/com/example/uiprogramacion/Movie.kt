package com.example.uiprogramacion

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val title: String,
    val description: String
)
