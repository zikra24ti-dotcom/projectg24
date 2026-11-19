package com.example.zikra.pertemuan_12.data.api

import com.example.zikra.pertemuan_12.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
