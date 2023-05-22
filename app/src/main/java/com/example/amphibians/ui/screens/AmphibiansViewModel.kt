package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibianPhotosApplication
import com.example.amphibians.data.AmphibianPhotosRepository
import com.example.amphibians.network.AmphibiansPhoto
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibiansUiState{
    data class Success(val amphibiansPhoto: List<AmphibiansPhoto>) : AmphibiansUiState
    object Loading : AmphibiansUiState
    object Error : AmphibiansUiState
}

class AmphibiansViewModel(private val amphibianPhotosRepository: AmphibianPhotosRepository): ViewModel() {
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
                amphibiansUiState = AmphibiansUiState.Success(
                    amphibianPhotosRepository.getAmphibians()
                )
            }catch (e: IOException){
                AmphibiansUiState.Error
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianPhotosApplication)
                val amphibianPhotosRepository = application.container.amphibianPhotosRepository
                AmphibiansViewModel(amphibianPhotosRepository = amphibianPhotosRepository)
            }
        }
    }
}


