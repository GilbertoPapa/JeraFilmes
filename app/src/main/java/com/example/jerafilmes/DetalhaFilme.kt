package com.example.jerafilmes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jerafilmes.model.Filme1

class DetalhaFilme : AppCompatActivity() {

    private var movie : Filme1? = null;
    //private lateinit var favoriteItemMenu: MenuItem;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhafilme)

        movie = intent.getParcelableExtra<Filme1>(EXTRA_MOVIE)

     //   title_movie.text = movie?.title
      //  overview_movie.text = movie?.overview
      //  date_movie.text = movie?.releaseDate
     //  vote_movie.text = movie?.voteAverage
     //   val backgroundImagePath = BASE_URL_BACK + movie?.backdropPath
     //   val posterImagePath = BASE_URL_BACK + movie?.posterPath
      //  Picasso.get().load(backgroundImagePath).into(backdrop_movie)
      //  Picasso.get().load(posterImagePath).into(poster_movie)
    }
    companion object {
        const val BASE_URL_BACK = "https://image.tmdb.org/t/p/original"
        const val EXTRA_MOVIE = "extra_movie"
    }
}