package com.luan.teste.presentation.profile.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.ViewState
import com.luan.teste.domain.interactor.GetUserByNameUseCase
import com.luan.teste.domain.interactor.GetUserUseCase
import com.luan.teste.domain.model.emoji.Emoji
import com.luan.teste.domain.model.profile.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProfileSearchViewModel(
    private val getUserUseCase: GetUserUseCase
    ): ViewModel() {

    private val _userListResponse = MutableStateFlow<ViewState<PagingData<User>>>(ViewState.Loading)
    val userListResponse: StateFlow<ViewState<PagingData<User>>>
        get() = _userListResponse

    fun getUsers(query: String? = null){
        viewModelScope.launch {
            getUserUseCase.execute(query)
                .catch {  _userListResponse.value = ViewState.Error(it) }
                .collect {
                    _userListResponse.value = when(it){
                        ApiResult.Empty ->  ViewState.Empty
                        is ApiResult.Error -> ViewState.Error(it.error)
                        ApiResult.Loading -> ViewState.Loading
                        is ApiResult.Success -> ViewState.Success(it.data)
                    }
                }
        }
    }
}