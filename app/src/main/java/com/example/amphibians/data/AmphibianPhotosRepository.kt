package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApi
import com.example.amphibians.network.AmphibiansPhoto

interface AmphibianPhotosRepository {
    suspend fun getAmphibians(): List<AmphibiansPhoto>
}
class NetworkAmphibianPhotosRepository: AmphibianPhotosRepository{
    override suspend fun getAmphibians(): List<AmphibiansPhoto> {
        return AmphibiansApi.retrofitService.getAmphibians()
    }
}