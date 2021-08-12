package com.example.jerafilmes.repository

import com.example.jerafilmes.data.network.APIService.API_KEY
import com.example.jerafilmes.data.network.APIService.LANGUAGE
import com.example.jerafilmes.data.network.APIService.retrofit
import com.example.jerafilmes.data.network.Filmeservice
import com.example.jerafilmes.model.Filme1

class FilmesRepository {

    fun getMovies(): List<Filme1> {
        val moviesService = retrofit.create(Filmeservice.MoviesService::class.java)
        val result = moviesService?.getMovies(API_KEY, LANGUAGE)?.execute()
        val moviesList: ArrayList<Filme1> = arrayListOf()
        if (result != null && result.isSuccessful) {
            result.body()?.results?.forEach { moviesResponse ->
                val movies = Filme1()
                movies.title = moviesResponse.title ?: ""
                movies.posterPath = moviesResponse.posterPath ?: ""
                movies.backdropPath = moviesResponse.backdropPath ?: ""
                movies.overview = moviesResponse.overview ?: ""
                movies.releaseDate = moviesResponse.releaseDate?: ""
                movies.voteAverage = moviesResponse.voteAverage ?: ""
                movies.popularity = moviesResponse.popularity ?: ""

                moviesList.add(movies)

            }
        }
        return moviesList
    }
}
