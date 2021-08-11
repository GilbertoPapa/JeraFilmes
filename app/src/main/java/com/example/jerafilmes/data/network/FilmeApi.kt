package com.example.jerafilmes.data.network

import com.example.jerafilmes.data.FilmeRemote
import com.example.jerafilmes.data.ProductionCompany
import retrofit2.http.GET

interface FilmeApi : List<ProductionCompany> {
    @GET("550?api_key=431a850a0fba26c71b2b2df478933b6c")
    suspend fun getFilmes():FilmeRemote}