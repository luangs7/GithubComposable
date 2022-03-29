package com.luan.teste.presentation.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.ViewState
import com.luan.teste.domain.interactor.GetRepositoriesUseCase
import com.luan.teste.domain.model.emoji.Emoji
import com.luan.teste.domain.model.repositories.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepoListViewModel(
    private val repositoriesUseCase: GetRepositoriesUseCase
): ViewModel() {

    private val _repoResponse = MutableStateFlow<ViewState<List<Repository>>>(ViewState.Empty)
    val repoResponse: StateFlow<ViewState<List<Repository>>>
        get() = _repoResponse

    init {
        getRepositories()
    }

    private fun getRepositories(){
        viewModelScope.launch {
            repositoriesUseCase.execute(Unit)
                .catch { _repoResponse.value = ViewState.Error(it) }
                .collect {
                    _repoResponse.value = when(it){
                        ApiResult.Empty -> ViewState.Empty
                        is ApiResult.Error -> ViewState.Error(it.error)
                        ApiResult.Loading -> ViewState.Loading
                        is ApiResult.Success -> ViewState.Success(it.data)
                    }
                }
        }
    }
}