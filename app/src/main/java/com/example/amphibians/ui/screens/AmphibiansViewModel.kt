package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.NetworkAmphibianPhotosRepository
import com.example.amphibians.network.AmphibiansApi
import com.example.amphibians.network.AmphibiansPhoto
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibiansUiState{
    data class Success(val amphibiansPhoto: String) : AmphibiansUiState
    object Loading : AmphibiansUiState
    object Error : AmphibiansUiState
}

class AmphibiansViewModel: ViewModel() {
    /** The mutable state that stores the status of the most recent request**/
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set
    /**
     * Call getAmphibians() on init so we can display status immediately
     */
    init {
        getAmphibians()
    }
    /**
     * Get Amphibian information from the AmphibianApi
     */
    private fun getAmphibians(){
        viewModelScope.launch{
            try {
                val amphibianPhotosRepository = NetworkAmphibianPhotosRepository()
                val listResult = amphibianPhotosRepository.getAmphibians()
                amphibiansUiState = AmphibiansUiState.Success(
                    "Success: ${listResult.size} species received"
                )
            }catch (e: IOException){
                AmphibiansUiState.Error
            }
        }
    }
}


