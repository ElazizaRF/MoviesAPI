package com.example.moviesapp.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.progressindicator.LinearProgressIndicator

class DetailsActivity : AppCompatActivity() {
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    private lateinit var imgeView: ImageView
    private lateinit var titleMV: CollapsingToolbarLayout
    private lateinit var tv: TextView
    private lateinit var tv_release: TextView
    private lateinit var progressionbar: LinearProgressIndicator

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        progressionbar = findViewById(R.id.progressBar)
        progressionbar.visibility = View.VISIBLE
        getData()


    }

    fun getData() {
        imgeView = findViewById(R.id.img_movie_detail)
        titleMV = findViewById(R.id.collapsing_toolbar)
        val poster = intent.getStringExtra(MovieActivity.MV_POSTER)
        Glide.with(this).load(IMAGE_BASE + poster).into(imgeView)
        titleMV.title = intent.getStringExtra(MovieActivity.MV_TITLE)
        tv = findViewById(R.id.tv_Info)
        tv_release = findViewById(R.id.tv_categoryInfo)
        tv_release.text = intent.getStringExtra(MovieActivity.MV_RELEASE)
        tv_release.visibility = View.VISIBLE
        progressionbar.visibility = View.INVISIBLE
    }
}