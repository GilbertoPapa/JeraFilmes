package com.example.jerafilmes.response

import com.example.jerafilmes.model.Filme1
import com.google.gson.annotations.SerializedName

data class FilmeListResponse (var results: ArrayList<Filme1>? = null,
                              var page: String? = "")

data class Filme (
    var title: String? = "",

    var overview: String? = "",

    @SerializedName("release_date")
    var releaseDate: String? = "",

    @SerializedName("backdrop_path")
    var backdropPath: String? = "",

    @SerializedName("poster_path")
    var posterPath: String? = "",

    @SerializedName("vote_average")
    var voteAverage: String? = "",

    var popularity: String? = "",
)