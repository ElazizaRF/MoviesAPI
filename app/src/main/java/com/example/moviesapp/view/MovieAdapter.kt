package com.cronocode.moviecatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    lateinit var onItemClick: ((Movie)-> Unit)
    private lateinit var  movies : List<Movie>
    fun setMovies(movies : List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : Movie){
            itemView.findViewById<TextView>(R.id.movie_title).text = movie.title
            itemView.findViewById<TextView>(R.id.movie_release_date).text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.findViewById(R.id.movie_poster))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
        holder.itemView.setOnClickListener {
            onItemClick.invoke(movies[position])
        }
    }
}