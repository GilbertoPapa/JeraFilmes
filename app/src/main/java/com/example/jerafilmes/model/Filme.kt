package com.example.jerafilmes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Filme1 (
    var title: String = "",

    var overview: String = "",

    var releaseDate: String = "",

    var backdropPath: String = "",

    var posterPath: String = "",

    var voteAverage: String = "",

    var popularity: String = ""
): Parcelable