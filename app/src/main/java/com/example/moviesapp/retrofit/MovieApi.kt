package com.example.moviesapp.retrofit

import com.cronocode.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    @GET("/3/movie/popular?api_key=b915d22ae6a6bbb0913d2264116eeb32")
    fun getMovieList(): Call<MovieResponse>
}