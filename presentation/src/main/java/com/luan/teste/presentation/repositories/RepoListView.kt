package com.luan.teste.presentation.repositories

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.luan.teste.common.base.ViewState
import com.luan.teste.common.extensions.flow
import com.luan.teste.designsystem.ui.components.infinitelist.InfiniteListHandler
import com.luan.teste.designsystem.ui.components.loading.LoadingView
import com.luan.teste.designsystem.ui.components.statusview.StatusView
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.domain.model.repositories.Repository
import com.luan.teste.presentation.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.androidx.compose.getViewModel

@Composable
fun RepoListView(viewModel: RepoListViewModel) {

    LaunchedEffect(key1 = Unit){
        viewModel.getRepositories()
    }

    AppTheme {
        RepoListContent(viewModel)
    }
}

@Composable
internal fun RepoListContent(
    viewModel: RepoListViewModel
){
    val responseState = viewModel.repoResponse.collectAsState()

    Crossfade(targetState = responseState) { state ->
        when (val response = state.value) {
            is ViewState.Empty -> StatusView(
                icon = R.drawable.box,
                text = stringResource(R.string.empty_label)
            )
            is ViewState.Error -> StatusView(
                icon = R.drawable.bankrupt,
                text = stringResource(R.string.error_label)
            )
            is ViewState.Loading -> LoadingView()
            is ViewState.Success -> RepoList(response.result.flow())
        }
    }
}

@Composable
internal fun RepoList(
    list: Flow<PagingData<Repository>>
) {
    val listState: LazyPagingItems<Repository> = list.collectAsLazyPagingItems()
    val lazyState = rememberLazyListState()

    LazyColumn(
        state= lazyState,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        items(listState) { item ->
            item?.let {
                RepoItemView(
                    item= it,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
                Divider(
                    color = Color.Gray.copy(alpha = 0.3f),
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 32.dp, top = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RepoListPreview() {
    RepoListView(getViewModel())
}