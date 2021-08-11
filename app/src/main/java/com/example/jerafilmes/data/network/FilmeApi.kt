package com.example.jerafilmes.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    const val API_KEY = "431a850a0fba26c71b2b2df478933b6c"
    const val LANGUAGE = "pt-BR"
}