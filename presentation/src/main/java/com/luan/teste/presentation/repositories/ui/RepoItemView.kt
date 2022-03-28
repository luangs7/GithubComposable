package com.luan.teste.presentation.repositories.ui

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.presentation.R


@Composable
fun RepoItemView(
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
            Text(text = "Nome do repositório", style = MaterialTheme.typography.body1)
            Text(text = "Description", style = MaterialTheme.typography.body2)
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
                Text(text = "5", style = MaterialTheme.typography.h6)
            }
        }
        AvatarWithUsername(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@Composable
internal fun AvatarWithUsername(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Image(
            painter =
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .shadow(3.dp, CircleShape)
                .size(42.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(text = "@username", style = MaterialTheme.typography.body2)
    }
}

@Preview(showBackground = true)
@Composable
fun RepoItemViewPreview() {
    AppTheme {
        RepoItemView()
    }
}