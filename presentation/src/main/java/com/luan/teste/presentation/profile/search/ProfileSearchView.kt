package com.luan.teste.presentation.profile.search

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.designsystem.ui.theme.Shapes

@Composable
fun ProfileSearchView() {
    AppTheme {
        ProfileSearchContent()
    }
}

@Composable
internal fun ProfileSearchContent() {
    val searchState = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        SearchView(searchValue = searchState)
        UserListView{
            //call activity
        }
    }
}

@Composable
internal fun UserListView(
    onItemClick: () -> Unit
) {
    val list = arrayListOf(1, 2, 3, 4, 5)
    LazyColumn {
        items(list) {
            UserItemView(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable { onItemClick.invoke() }
            )
        }
    }
}


@Composable
internal fun SearchView(
    searchValue: MutableState<TextFieldValue>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, Shapes.small)
                .wrapContentHeight()
        ) {
            TextField(
                modifier = modifier
                    .fillMaxWidth(),
                value = searchValue.value,
                onValueChange = { searchValue.value = it },
                placeholder = {
                    Text(
                        text = "Digite um usuário",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun ProfileSearchViewPreview() {
    ProfileSearchView()
}