package com.luan.teste.presentation.profile.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.ViewState
import com.luan.teste.domain.interactor.GetUserByNameUseCase
import com.luan.teste.domain.model.profile.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserByNameUseCase: GetUserByNameUseCase
): ViewModel() {

    private val _userResponse = MutableStateFlow<ViewState<User>>(ViewState.Loading)
    val userResponse: StateFlow<ViewState<User>>
        get() = _userResponse

    fun getUsersByUsername(username:String){
        viewModelScope.launch {
            getUserByNameUseCase.execute(username)
                .catch {  _userResponse.value = ViewState.Error(it) }
                .collect {
                    _userResponse.value = when(it){
                        ApiResult.Empty ->  ViewState.Empty
                        is ApiResult.Error -> ViewState.Error(it.error)
                        ApiResult.Loading -> ViewState.Loading
                        is ApiResult.Success -> ViewState.Success(it.data)
                    }
                }
        }
    }
}