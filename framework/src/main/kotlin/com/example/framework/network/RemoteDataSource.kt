package com.example.framework.network

import com.example.data.IRemoteDataSource
import com.example.data.NetworkResult
import com.example.domain.Movie

class RemoteDataSource(
    val retrofit: RetrofitBuilder
): IRemoteDataSource {
    override suspend fun fetchData(): NetworkResult<List<Movie>> {
        val response = retrofit.apiService.fetchData()

        if(response.isSuccessful){
            val networkResponse= response.body()
            return NetworkResult.Success(
                networkResponse!!.results.map{
                    it.toMovie()
                }
            )
        }else{
            return NetworkResult.Error(response.errorBody()!!.string())
                }
        }
}