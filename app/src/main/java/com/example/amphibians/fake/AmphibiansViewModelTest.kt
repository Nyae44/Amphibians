package com.example.amphibians.fake

import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.screens.AmphibiansUiState
import com.example.amphibians.ui.screens.AmphibiansViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun amphibiansViewModel_getAmphibians_veifyAmphibiansUiStateSuccess()= runTest{
        val amphibiansViewModel = AmphibiansViewModel(
            amphibianPhotosRepository = FakeAmphibianPhotosRepository()
        )
        assertEquals(
            AmphibiansUiState.Success("Success: ${FakeDataSource.photosList.size} species received"),
            amphibiansViewModel.amphibiansUiState
        )
    }
}