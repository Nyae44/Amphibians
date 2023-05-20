package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService
import com.example.amphibians.network.AmphibiansPhoto

interface AmphibianPhotosRepository {
    suspend fun getAmphibians(): List<AmphibiansPhoto>
}
class NetworkAmphibianPhotosRepository(private val amphibiansApiService: AmphibiansApiService): AmphibianPhotosRepository{
    override suspend fun getAmphibians(): List<AmphibiansPhoto> {
        return amphibiansApiService.getAmphibians()
    }
}