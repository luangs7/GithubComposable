package com.luan.teste.presentation.profile.details

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.luan.teste.common.base.ViewState
import com.luan.teste.designsystem.ui.components.loading.LoadingView
import com.luan.teste.designsystem.ui.components.statusview.StatusView
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.designsystem.ui.theme.descriptionStyle
import com.luan.teste.designsystem.ui.theme.title
import com.luan.teste.domain.model.profile.User
import com.luan.teste.presentation.R
import com.luan.teste.presentation.profile.search.ProfileSearchViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileView(
    searchViewModel: ProfileViewModel,
    username: String
) {
    val userState = searchViewModel.userResponse.collectAsState()
    searchViewModel.getUsersByUsername(username)

    Crossfade(userState) { state ->
        when (val value = state.value) {
            is ViewState.Empty, is ViewState.Error -> StatusView(
                icon = R.drawable.bankrupt,
                text = stringResource(R.string.error_label)
            )
            is ViewState.Success -> ProfileContentView(value.result)
        }
    }
}

@Composable
internal fun ProfileContentView(
    item: User
) {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProfileHeader(item = item, modifier = Modifier.padding(16.dp))
            Divider(
                color = Color.Gray.copy(alpha = 0.5f),
                thickness = 1.dp,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp)
            )
            ProfileInformations(
                item = item,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
internal fun ProfileHeader(
    item: User,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.avatar)
                .crossfade(true)
                .build(),
            contentDescription = String(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(72.dp)
                .align(Alignment.CenterHorizontally),
            placeholder = painterResource(id = R.drawable.ic_launcher_background)
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        if (item.bio.isNotEmpty()) {
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = item.bio,
                style = descriptionStyle
            )
        }
    }
}

@Composable
internal fun ProfileInformations(
    item: User,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ProfileInformationRow("Company", item.company)
        ProfileInformationRow("Blog", item.blog)
        ProfileInformationRow("Location", item.location)
        ProfileInformationRow("Username", item.login)
        ProfileInformationRow("Email", item.email)
        ProfileInformationRow("Twitter", item.twitter_username)

        Button(
            onClick = {
                uriHandler.openUri(item.url)
            },
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.show_webpage),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
internal fun ProfileInformationRow(
    key: String,
    value: String
) {
    if (value.isNotEmpty()) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.star_big_on),
                contentDescription = String(),
                modifier = Modifier.size(16.dp)
            )
            Text(text = "$key:", style = title)
            Text(
                text = value,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun ProfilePreview() {
    ProfileView(getViewModel(), username = String())
}