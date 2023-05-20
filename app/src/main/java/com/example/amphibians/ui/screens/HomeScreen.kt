package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
){
    when(amphibiansUiState){
        is AmphibiansUiState.Success -> ResultScreen(
            amphibiansUiState = amphibiansUiState.amphibiansPhoto, modifier
        )
        is AmphibiansUiState.Loading -> LoadingScreen()
        is AmphibiansUiState.Error -> ErrorScreen()

    }
}

/**
 * The home screen displaying result of fetching the amphibian details
 */
@Composable
fun ResultScreen(amphibiansUiState: String,modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(amphibiansUiState)
    }
}
@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
   Box(
       contentAlignment = Alignment.Center,
       modifier = modifier.fillMaxSize()
   ) {
       Image(
           modifier = Modifier.size(200.dp),
           painter = painterResource(id = R.drawable.loading_img), 
           contentDescription = stringResource(id = R.string.loading)
       )
   }
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ){
        Text(text = stringResource(id = R.string.loading_failed))
    }
}
@Preview(showBackground = true)
@Composable
fun ResultScreenPreview(){
    AmphibiansTheme {
        ResultScreen(stringResource(id = R.string.placeholder_result))
    }
}
