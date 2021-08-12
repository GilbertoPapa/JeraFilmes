package com.example.jerafilmes.data.network

import com.example.jerafilmes.response.FilmeListResponse
import retrofit2.http.GET
import retrofit2.http.Query




interface Filmeservice {

    interface MoviesService {
        @GET("3/trending/movie")
        fun getMovies(@Query("api_key") key: String,
                      @Query("language") language: String):
                retrofit2.Call<FilmeListResponse>
    }
}