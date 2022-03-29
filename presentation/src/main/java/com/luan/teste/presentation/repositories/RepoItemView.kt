package com.luan.teste.presentation.repositories

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.luan.teste.designsystem.ui.theme.descriptionStyle
import com.luan.teste.domain.model.repositories.Repository

@Composable
fun RepoItemView(
    item: Repository,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            Text(text = item.fullName, style = MaterialTheme.typography.body1)
            Text(text = item.description, style = descriptionStyle)
            Row(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(android.R.drawable.star_big_on),
                    contentDescription = String(),
                    modifier = Modifier
                        .size(16.dp)
                )
                Text(text = item.starCount.toString(), style = MaterialTheme.typography.h6)
            }
        }
        AvatarWithUsername(
            item= item,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@Composable
internal fun AvatarWithUsername(
    item: Repository,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model= ImageRequest.Builder(LocalContext.current)
                .data(item.owner.avatar)
                .diskCachePolicy(CachePolicy.ENABLED)
                .crossfade(true)
                .build(),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .shadow(3.dp, CircleShape)
                .size(42.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(text = item.owner.username, style = MaterialTheme.typography.body2)
    }
}
