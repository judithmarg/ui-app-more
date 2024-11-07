package com.example.framework.network

import com.example.domain.Movie


fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = "",
        title = title,
        description = description,
        posterPath = posterPath

    )
}