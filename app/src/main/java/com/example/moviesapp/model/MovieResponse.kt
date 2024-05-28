package com.cronocode.moviecatalog.models


import android.os.Parcel
import android.os.Parcelable
import com.example.moviesapp.model.Movie
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies : List<Movie>

) : Parcelable {
    constructor() : this(mutableListOf())

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    companion object : Parceler<MovieResponse> {
        override fun MovieResponse.write(dest: Parcel, flags: Int) {
            TODO("Not yet implemented")
        }

        override fun create(parcel: Parcel): MovieResponse = TODO()
    }
}