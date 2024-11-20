package com.example.framework.network

import retrofit2.Response
import retrofit2.http.GET

interface IApiService {
    @GET("/3/discover/movie?page=3&api_key=5740e9fe49b8252e514c6daa48d6463a&language=es")
    suspend fun fetchData(): Response<NetworkResponse>
}