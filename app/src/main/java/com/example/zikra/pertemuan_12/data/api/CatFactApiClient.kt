package com.example.zikra.pertemuan_12.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatFactApiClient {
    // Base URL Retrofit wajib diakhiri "/"
    private const val BASE_URL = "https://catfact.ninja/"

    val apiService: CatFactApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatFactApiService::class.java)
    }
}
