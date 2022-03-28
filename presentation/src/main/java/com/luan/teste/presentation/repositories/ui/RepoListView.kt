package com.luan.teste.presentation.repositories.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.designsystem.ui.theme.AppTheme

@Composable
fun RepoListView() {
    AppTheme {
        RepoList()
    }
}


@Composable
internal fun RepoList() {
    val list = arrayListOf(1, 2, 3, 4, 5)
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        items(list) {
            RepoItemView(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            Divider(
                color = Color.Gray.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(start = 32.dp, top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RepoListPreview() {
    RepoListView()
}