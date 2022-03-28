package com.luan.teste.presentation.emoji

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luan.teste.common.base.ViewState
import com.luan.teste.domain.emoji.model.Emoji
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EmojiListViewModel: ViewModel() {
    private val _userListResponse = MutableStateFlow<ViewState<List<Emoji>>>(ViewState())
    val userListResponse: StateFlow<ViewState<List<Emoji>>>
        get() = _userListResponse


}