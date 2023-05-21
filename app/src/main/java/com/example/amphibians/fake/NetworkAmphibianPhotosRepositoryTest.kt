package com.example.amphibians.fake

import com.example.amphibians.data.NetworkAmphibianPhotosRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test


class NetworkAmphibianPhotosRepositoryTest {
    @Test
    fun networkAmphibianPhotosRepository_getAmphibians_verifyPhotosList() = runTest{
        val repository = NetworkAmphibianPhotosRepository(
            amphibiansApiService = FakeAmphibiansApiService()
        )
        assertEquals(FakeDataSource.photosList, repository.getAmphibians())
    }
}