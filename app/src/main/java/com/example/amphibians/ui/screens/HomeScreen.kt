package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.network.AmphibiansPhoto
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
){
    when(amphibiansUiState){
        is AmphibiansUiState.Success -> PhotosGridScreen(
            photos = amphibiansUiState.amphibiansPhoto, modifier = Modifier
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
@Composable
fun AmphibiansPhotoCard(photo: AmphibiansPhoto, modifier: Modifier = Modifier){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photo.imgSrc)
            .crossfade(true)
            .build(),
        error = painterResource(id = R.drawable.ic_broken_image),
        placeholder = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(id = R.string.amphibian_photo),
        contentScale = ContentScale.FillBounds
    )
}
@Composable
fun PhotosGridScreen(photos: List<AmphibiansPhoto>, modifier: Modifier = Modifier) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(4.dp)
        ) {
            itemsIndexed(photos) { index, photo ->
                AmphibiansPhotoCard(photo = photo)
            }
        }

}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview(){
    AmphibiansTheme {
        ResultScreen(stringResource(id = R.string.placeholder_result))
    }
}
