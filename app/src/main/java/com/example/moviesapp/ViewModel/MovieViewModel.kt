package com.example.moviesapp.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cronocode.moviecatalog.models.MovieResponse
import com.example.moviesapp.model.Movie
import com.example.moviesapp.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private var MoviesLiveData = MutableLiveData<List<Movie>>()
    fun getMovieData() {
        RetrofitInstance.movieApi.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d( "HomeMovies",t.message.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//                 MoviesLiveData.postValue(callback(response.body()!!.movies))
//                return callback(response.body()!!.movies)
                MoviesLiveData.value = response.body()!!.movies
            }


        })
    }
    fun observerMoviesLiveData():LiveData<List<Movie>>{
        return MoviesLiveData
    }
}


