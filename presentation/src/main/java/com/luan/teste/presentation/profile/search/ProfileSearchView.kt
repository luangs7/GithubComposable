package com.luan.teste.presentation.profile.search

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.luan.estar.navigation.DestinationDeepLink
import com.luan.teste.common.base.ViewState
import com.luan.teste.common.extensions.flow
import com.luan.teste.designsystem.ui.components.loading.LoadingView
import com.luan.teste.designsystem.ui.components.searchview.SearchView
import com.luan.teste.designsystem.ui.components.statusview.StatusView
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.domain.model.profile.User
import com.luan.teste.presentation.R
import com.luan.teste.presentation.profile.details.ProfileNavItem
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileSearchView(
    navigateController: NavHostController,
    searchViewModel: ProfileSearchViewModel
) {
    AppTheme {
        ProfileSearchContent(navigateController, searchViewModel)
    }
}

@Composable
internal fun ProfileSearchContent(
    navigateController: NavHostController,
    searchViewModel: ProfileSearchViewModel
) {
    val searchState = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        SearchView(
            label = stringResource(id = R.string.search_label),
            searchValue = searchState
        ) { query ->
            searchViewModel.getUsers(query)
        }
        UserListContent(searchViewModel, navigateController)
    }
}

@Composable
internal fun UserListContent(
    searchViewModel: ProfileSearchViewModel,
    navigateController: NavHostController
) {
    val userListState = searchViewModel.userListResponse.collectAsState()

    Crossfade(targetState = userListState) { state ->
        when (val response = state.value) {
            is ViewState.Empty, is ViewState.Error -> StatusView(
                icon = R.drawable.box,
                text = stringResource(R.string.empty_label)
            )
            ViewState.Loading -> LoadingView(
                backgroudColor = Color.White,
                progressColor = Color.DarkGray
            )
            is ViewState.Success -> UserListView(response.result.flow()) {
                navigateController.navigate(DestinationDeepLink.passUsername(it.login))
            }
        }
    }

}

@Composable
internal fun UserListView(
    list: Flow<PagingData<User>>,
    onItemClick: (User) -> Unit
) {
    val listState = list.collectAsLazyPagingItems()

    LazyColumn {
        items(listState) { item ->
            item?.let {
                UserItemView(
                    user = it,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .clickable { onItemClick.invoke(it) }
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
internal fun ProfileSearchViewPreview() {
    ProfileSearchView(rememberNavController(), getViewModel())
}