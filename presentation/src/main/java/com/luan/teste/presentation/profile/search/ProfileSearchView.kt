package com.luan.teste.presentation.profile.search

import android.widget.SearchView
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.luan.teste.common.base.ViewState
import com.luan.teste.designsystem.ui.components.loading.LoadingView
import com.luan.teste.designsystem.ui.components.searchview.SearchView
import com.luan.teste.designsystem.ui.components.statusview.StatusView
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.domain.model.profile.User
import com.luan.teste.presentation.R
import com.luan.teste.presentation.profile.ProfileViewModel
import com.luan.teste.presentation.profile.details.ProfileNavItem
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileSearchView(
    navigateController: NavHostController
) {
    AppTheme {
        ProfileSearchContent(navigateController)
    }
}

@Composable
internal fun ProfileSearchContent(
    navigateController: NavHostController
) {
    val searchState = remember { mutableStateOf(TextFieldValue()) }
    val viewModel: ProfileViewModel = getViewModel()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        SearchView(
            label = stringResource(id = R.string.search_label),
            searchValue = searchState
        ) { query ->
            if (query.isEmpty()) viewModel.getUsers()
            else viewModel.getUsersByUsername(query)
        }
        UserListContent(viewModel, navigateController)
    }
}

@Composable
internal fun UserListContent(
    viewModel: ProfileViewModel,
    navigateController: NavHostController
) {
    val userListState = viewModel.userListResponse.collectAsState()

    when (val state = userListState.value) {
        is ViewState.Empty, is ViewState.Error -> StatusView(
            icon = R.drawable.box,
            text = stringResource(R.string.empty_label)
        )
        ViewState.Loading -> LoadingView(
            backgroudColor = Color.White,
            progressColor = Color.DarkGray
        )
        is ViewState.Success -> UserListView(state.result) {
            navigateController.navigate("${ProfileNavItem.ProfileDetails.route}/${it.login}")
        }
    }
}

@Composable
internal fun UserListView(
    list: List<User>,
    onItemClick: (User) -> Unit
) {
    LazyColumn {
        items(list.count()) {
            UserItemView(
                user = list[it],
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable { onItemClick.invoke(list[it]) }
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
internal fun ProfileSearchViewPreview() {
    ProfileSearchView(rememberNavController())
}