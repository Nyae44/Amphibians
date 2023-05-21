package com.example.amphibians.fake

import com.example.amphibians.data.AmphibianPhotosRepository
import com.example.amphibians.network.AmphibiansPhoto

class FakeAmphibianPhotosRepository : AmphibianPhotosRepository {
    override suspend fun getAmphibians(): List<AmphibiansPhoto> {
        return FakeDataSource.photosList
    }
}