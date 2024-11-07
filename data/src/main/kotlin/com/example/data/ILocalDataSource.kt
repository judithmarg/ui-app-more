package com.example.data

import com.example.domain.Movie

interface ILocalDataSource {
    fun getList(): List<Movie>
}