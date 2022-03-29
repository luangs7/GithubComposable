package com.luan.teste.presentation.profile

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.common.base.ViewState
import com.luan.teste.designsystem.ui.components.LoadingView
import com.luan.teste.designsystem.ui.components.StatusView
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.designsystem.ui.theme.descriptionStyle
import com.luan.teste.designsystem.ui.theme.title
import com.luan.teste.domain.model.profile.User
import com.luan.teste.presentation.R
import com.luan.teste.presentation.emoji.EmojiListContent
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileView(
    viewModel: ProfileViewModel = getViewModel()
) {
    val userState = viewModel.userResponse.collectAsState()

    Crossfade(userState) { state ->
        when(val value = state.value){
            is ViewState.Empty -> StatusView(icon = R.drawable.box, text = "Não houve resultados para sua busca.")
            is ViewState.Error -> StatusView(icon = R.drawable.bankrupt, text = "Ocorreu um erro ao processar sua solicitação. Tente novamente mais tarde.")
            is ViewState.Loading -> LoadingView()
            is ViewState.Success -> ProfileContentView(value.result)
        }
    }

}

@Composable
internal fun ProfileContentView(
    item: User
){
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProfileHeader(item = item,modifier = Modifier.padding(16.dp))
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
        Image(
            painter =
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = String(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .shadow(8.dp, CircleShape)
                .size(56.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = item.bio,
            style = descriptionStyle
        )
    }
}

@Composable
internal fun ProfileInformations(
    item: User,
    modifier: Modifier = Modifier
) {
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
            onClick = { },
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 8.dp)
        ) {
            Text(
                text = "Ver perfil na web",
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
internal fun ProfileInformationRow(
    key:String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = android.R.drawable.star_big_on),
            contentDescription = String()
        )
        Text(text = "$key:", style = title)
        Text(
            text = value,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
internal fun ProfilePreview() {
    ProfileView()
}