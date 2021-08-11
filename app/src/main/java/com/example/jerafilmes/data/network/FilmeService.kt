package com.example.jerafilmes.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object FilmeService {
    val service: FilmeApi by lazy {
        retrofit.create(FilmeApi::class.java)
    }
}

