package com.luan.teste.presentation.profile.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.luan.teste.designsystem.ui.theme.Shapes
import com.luan.teste.domain.model.profile.User

@Composable
fun UserItemView(
    user: User,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 3.dp,
        shape = Shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user.avatar)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(56.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(text = "@${user.login}", style = MaterialTheme.typography.body2)
        }
    }
}