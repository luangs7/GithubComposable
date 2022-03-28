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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.designsystem.ui.theme.Shapes

@Composable
fun UserItemView(
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 3.dp,
        shape = Shapes.medium,
        modifier =  modifier.fillMaxWidth().wrapContentHeight().padding(top = 4.dp, bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter =
                painterResource(id = com.luan.teste.presentation.R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .shadow(3.dp, CircleShape)
                    .size(42.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(text = "@username", style = MaterialTheme.typography.body2)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserItemViewPreview() {
    UserItemView()
}