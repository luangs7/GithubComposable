package com.luan.teste.presentation.emoji

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.designsystem.ui.theme.Shapes
import com.luan.teste.presentation.R

@Composable
fun EmojiItemView(
    url: String,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 3.dp,
        shape = Shapes.medium,
        modifier = modifier.size(54.dp).padding(2.dp)
    ) {
        AsyncImage(
            model= ImageRequest.Builder(LocalContext.current)
                .data(url)
                .diskCachePolicy(CachePolicy.ENABLED)
                .crossfade(true)
                .build(),
            contentDescription = String(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun EmojiItemPreview(){
    AppTheme {
        EmojiItemView(String())
    }
}