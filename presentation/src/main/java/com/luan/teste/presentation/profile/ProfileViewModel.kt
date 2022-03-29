package com.luan.teste.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getUserByNameUseCase: GetUserByNameUseCase
): ViewModel() {

    private val _userListResponse = MutableStateFlow<ViewState<List<User>>>(ViewState.Empty)
    val userListResponse: StateFlow<ViewState<List<User>>>
        get() = _userListResponse

    private val _userResponse = MutableStateFlow<ViewState<User>>(ViewState.Empty)
    val userResponse: StateFlow<ViewState<User>>
        get() = _userResponse

    init {
        getUsers()
    }

    fun getUsers(){
        viewModelScope.launch {
            getUserUseCase.execute(Unit)
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