package com.luan.teste.presentation.emoji

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.designsystem.ui.theme.AppTheme

@ExperimentalFoundationApi
@Composable
fun EmojiListView() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            EmojiList()
        }
    }
}

@ExperimentalFoundationApi
@Composable
internal fun EmojiList(
    viewModel: EmojiListViewModel = EmojiListViewModel()
) {
    val listState = viewModel.userListResponse.collectAsState()

    val state = rememberLazyListState()

    LazyVerticalGrid(
        modifier= Modifier.padding(start = 4.dp, end= 4.dp, top = 16.dp),
        cells = GridCells.Adaptive(54.dp),
        state = state,
        verticalArrangement= Arrangement.spacedBy(2.dp),
        horizontalArrangement= Arrangement.spacedBy(2.dp),
        content = {
            items(listState.value.result ?: listOf()) {
                EmojiItemView()
            }
        }
    )
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun EmojiListPreview() {
    EmojiListView()
}