package com.example.consumerestapi.repository

import com.example.consumerestapi.model.Kontak
import com.example.consumerestapi.network.KontakService
import java.io.IOException

interface KontakRepository {
    /** Fetches list of kontak from kontakApi */
    suspend fun getKontak(): List<Kontak>
    suspend fun insertKontak(kontak: Kontak)
    suspend fun deleteKontak(id: Int)
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /** Fetches list of kontak from kontakApi */
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    // insert kontak
    override suspend fun insertKontak(kontak: Kontak) {
        kontakApiService.insertKontak(kontak)
    }

    override suspend fun deleteKontak(id: Int) {
        try {
            val response = kontakApiService.deleteKontak(id)
            if (!response.isSuccessful) {
                // Handle unsuccessful response (non-2xx status code)
                throw IOException("Failed to delete Kontak. HTTP status code: ${response.code()}")
            }
            else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}