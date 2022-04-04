package com.luan.teste.presentation.emoji

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.common.base.ViewState
import com.luan.teste.designsystem.ui.components.loading.LoadingView
import com.luan.teste.designsystem.ui.components.statusview.StatusView
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.domain.model.emoji.Emoji
import com.luan.teste.presentation.R
import org.koin.androidx.compose.getViewModel
import androidx.compose.foundation.lazy.grid.rememberLazyGridState

@ExperimentalFoundationApi
@Composable
fun EmojiListView(viewModel: EmojiListViewModel) {

    LaunchedEffect(Unit) {
        viewModel.getEmojis()
    }
    AppTheme {
        EmojiList(viewModel)
    }
}

@ExperimentalFoundationApi
@Composable
internal fun EmojiList(
    viewModel: EmojiListViewModel
) {
    val listState = viewModel.emojiResponse.collectAsState()

    Crossfade(listState) { state ->
        when (val value = state.value) {
            is ViewState.Empty -> StatusView(
                icon = R.drawable.box,
                text = stringResource(R.string.empty_label)
            )
            is ViewState.Error -> StatusView(
                icon = R.drawable.bankrupt,
                text = stringResource(R.string.error_label)
            )
            is ViewState.Loading -> LoadingView()
            is ViewState.Success -> EmojiListContent(list = value.result)
        }
    }
}

@ExperimentalFoundationApi
@Composable
internal fun EmojiListContent(
    list: List<Emoji>
) {

    val state = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(54.dp),
        state = state,
        modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(list.count()) { index ->
            EmojiItemView(url = list[index].source)
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun EmojiListPreview() {
    EmojiListView(getViewModel())
}