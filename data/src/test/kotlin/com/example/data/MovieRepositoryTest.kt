package com.example.data

import com.example.domain.Movie
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    val remoteDataSource: IRemoteDataSource = mock()
    val localDataSource: ILocalDataSource = mock()

//runtest lo tenemos gracias a coroutines, ademas es necesario para las funciones de suspend
    @Test
    fun obtainMovies() = runTest {
        //ARRANGE
        val movieRepository = MovieRepository(localDataSource, remoteDataSource)
        val list: List<Movie> = listOf(Movie(1,"","",""))
        val localResult: NetworkResult<List<Movie>> = NetworkResult.Success(list)
        Mockito.`when`(localDataSource.getList()).thenReturn(localResult)
    //ACT
        val finalList = movieRepository.obtainMovies(false)
        //ASSERT
        assertEquals(finalList.size, list.size)
    }

    @Test
    fun findById() {
        val movieRepository = MovieRepository(localDataSource, remoteDataSource)
        val movieInternt = Movie(1,"","","")
        val localResult: NetworkResult<Movie> = NetworkResult.Success(movieInternt)
        Mockito.`when`(localDataSource.findById(anyString())).thenReturn(localResult)
        //ACT
        val movie = movieRepository.findById("1")
        //ASSERT
        assertEquals(movieInternt.id, movie?.id)

    }

    @Test
    fun getLocalDataSource() {
    }

    @Test
    fun getRemoteDataSource() {
    }
}