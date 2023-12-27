package com.example.consumerestapi.network

import com.example.consumerestapi.model.Kontak
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("kontak")
    suspend fun  getKontak(): List<Kontak>

    @POST("/kontak")
    suspend fun insertKontak(@Body kontak: Kontak)
}