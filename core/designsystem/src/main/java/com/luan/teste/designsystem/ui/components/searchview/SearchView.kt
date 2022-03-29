package com.luan.teste.designsystem.ui.components.searchview

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.luan.teste.designsystem.ui.theme.Shapes

@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    label: String,
    searchValue: MutableState<TextFieldValue>,
    onSearch: (String) -> Unit
) {

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, Shapes.small)
                .wrapContentHeight()
        ) {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                value = searchValue.value,
                onValueChange = {
                    searchValue.value = it
                },
                placeholder = {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    focusManager.clearFocus(force = true)
                    onSearch(searchValue.value.text)
                })
            )
        }
    }
}