package com.luan.teste.presentation.emoji

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.ViewState
import com.luan.teste.domain.interactor.GetEmojiListUseCase
import com.luan.teste.domain.model.emoji.Emoji
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class EmojiListViewModel(
    private val useCase: GetEmojiListUseCase
) : ViewModel() {

    private val _emojiResponse = MutableStateFlow<ViewState<List<Emoji>>>(ViewState.Loading)
    val emojiResponse: StateFlow<ViewState<List<Emoji>>>
        get() = _emojiResponse

    fun getEmojis() {
        viewModelScope.launch {
            useCase.execute(Unit)
                .catch { _emojiResponse.value = ViewState.Error(it) }
                .collect {
                    _emojiResponse.value = when (it) {
                        ApiResult.Empty -> ViewState.Empty
                        is ApiResult.Error -> ViewState.Error(it.error)
                        ApiResult.Loading -> ViewState.Loading
                        is ApiResult.Success -> ViewState.Success(it.data)
                    }
                }
        }
    }
}