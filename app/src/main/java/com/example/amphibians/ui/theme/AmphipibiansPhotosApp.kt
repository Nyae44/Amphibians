@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.amphibians.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screens.AmphibiansViewModel
import com.example.amphibians.ui.screens.HomeScreen


@Composable
fun AmphibiansPhotosApp(modifier: Modifier = Modifier){
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { stringResource(id = R.string.app_name)}) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            val amphibiansViewModel: AmphibiansViewModel = viewModel()
            HomeScreen(amphibiansUiState = amphibiansViewModel.amphibiansUiState)
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun AmphibiansPhotosAppPreview(){
    AmphibiansTheme(darkTheme = false) {
        AmphibiansPhotosApp()
    }
}