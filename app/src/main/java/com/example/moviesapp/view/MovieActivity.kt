package com.example.moviesapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cronocode.moviecatalog.MovieAdapter
import com.cronocode.moviecatalog.models.MovieResponse
import com.example.moviesapp.R
import com.example.moviesapp.ViewModel.MovieViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class MovieActivity : AppCompatActivity() {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var rv_movies_list: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    companion object{
        val MV_Id ="com.example.moviesapp.view.MovieId"
        val MV_TITLE  ="com.example.moviesapp.view.MovieTITLE "
        val MV_POSTER  ="com.example.moviesapp.view.MoviePOSTER"
        val MV_RELEASE="com.example.moviesapp.view.MovieRELEASE"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieAdapter = MovieAdapter()
        rv_movies_list = findViewById(R.id.rv_movies_list)
        rv_movies_list.layoutManager = LinearLayoutManager(this, GridLayoutManager.VERTICAL, false)
        rv_movies_list.setHasFixedSize(true)
        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        movieViewModel.getMovieData()
        observerMoviesLiveData()
        ClickOnRecyclerView()
    }

    private fun ClickOnRecyclerView() {
            movieAdapter.onItemClick = {movie->

                val intent = Intent(applicationContext,DetailsActivity::class.java)
                intent.putExtra(MV_Id,movie.id)
                intent.putExtra(MV_TITLE,movie.title)
                intent.putExtra(MV_POSTER,movie.poster)
                intent.putExtra(MV_RELEASE,movie.release)
                startActivity(intent)

            }
    }

    private fun observerMoviesLiveData() {
        movieViewModel.observerMoviesLiveData().observe(this) { movies ->
            movieAdapter.setMovies(movies)
            rv_movies_list.adapter = movieAdapter
        }
    }


}