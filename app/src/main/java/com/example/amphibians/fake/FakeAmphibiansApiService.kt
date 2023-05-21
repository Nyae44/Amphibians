package com.example.amphibians.fake

import com.example.amphibians.network.AmphibiansApiService
import com.example.amphibians.network.AmphibiansPhoto

class FakeAmphibiansApiService: AmphibiansApiService {
    override suspend fun getAmphibians(): List<AmphibiansPhoto> {
        return FakeDataSource.photosList
    }
}