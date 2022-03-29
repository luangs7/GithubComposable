package com.luan.teste.presentation.repositories

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.common.base.ViewState
import com.luan.teste.designsystem.ui.components.LoadingView
import com.luan.teste.designsystem.ui.components.StatusView
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.domain.model.repositories.Repository
import com.luan.teste.presentation.R
import org.koin.androidx.compose.getViewModel

@Composable
fun RepoListView() {
    AppTheme {
        RepoListContent()
    }
}

@Composable
internal fun RepoListContent(
    viewModel: RepoListViewModel = getViewModel()
){
    val responseState = viewModel.repoResponse.collectAsState()

    when(val response = responseState.value){
        is ViewState.Empty -> StatusView(icon = R.drawable.box, text = "Não houve resultados para sua busca.")
        is ViewState.Error -> StatusView(icon = R.drawable.bankrupt, text = "Ocorreu um erro ao processar sua solicitação. Tente novamente mais tarde.")
        is ViewState.Loading -> LoadingView()
        is ViewState.Success -> RepoList(response.result)
    }
}

@Composable
internal fun RepoList(
    list: List<Repository>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        items(list.count()) {
            RepoItemView(
                item= list[it],
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RepoListPreview() {
    RepoListView()
}