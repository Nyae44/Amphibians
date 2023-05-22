package com.example.amphibians.rules

import com.example.amphibians.fake.FakeAmphibianPhotosRepository
import com.example.amphibians.fake.FakeDataSource
import com.example.amphibians.ui.screens.AmphibiansUiState
import com.example.amphibians.ui.screens.AmphibiansViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {
    @get:
    Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun amphibiansViewModel_getAmphibians_verifyAmphibiansUiStateSuccess()= runTest{
        val amphibiansViewModel = AmphibiansViewModel(
            amphibianPhotosRepository = FakeAmphibianPhotosRepository()
        )
        assertEquals(
            AmphibiansUiState.Success(FakeDataSource.photosList),
            amphibiansViewModel.amphibiansUiState
        )
    }
}