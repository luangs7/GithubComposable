package com.luan.teste.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.designsystem.ui.theme.descriptionStyle
import com.luan.teste.designsystem.ui.theme.title
import com.luan.teste.presentation.R
import com.luan.teste.presentation.repositories.ui.RepoList

@Composable
fun ProfileView() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ProfileHeader(modifier = Modifier.padding(16.dp))
            Divider(
                color = Color.Gray.copy(alpha = 0.5f),
                thickness = 1.dp,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp)
            )
            ProfileInformations(
                modifier = Modifier.padding(16.dp)
            )
            RepoList()
        }
    }
}

@Composable
internal fun ProfileHeader(
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
            text = "Fulano de Tal",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = "Fulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de TalFulano de Tal",
            style = descriptionStyle
        )
    }
}

//"name": "monalisa octocat",
//"company": "GitHub",
//"blog": "https://github.com/blog",
//"location": "San Francisco",
//"email": "octocat@github.com",
//"bio": "There once was...",
//"twitter_username": "monatheoctocat",

@Composable
internal fun ProfileInformations(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ProfileInformationRow()
        ProfileInformationRow()
        ProfileInformationRow()
        ProfileInformationRow()

        Button(
            onClick = { },
            modifier = Modifier
                .wrapContentWidth()
                .padding(top= 8.dp)
        ) {
            Text(
                text = "Ver perfil na web",
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
internal fun ProfileInformationRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = android.R.drawable.star_big_on),
            contentDescription = String()
        )
        Text(text = "Bio:", style = title)
        Text(
            text = "Fulano de Tal",
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