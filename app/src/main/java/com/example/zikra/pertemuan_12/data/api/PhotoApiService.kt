package com.example.zikra.pertemuan_12.data.api

import com.example.zikra.pertemuan_12.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}
