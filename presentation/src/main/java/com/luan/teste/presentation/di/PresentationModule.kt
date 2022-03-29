package com.luan.teste.presentation.di

import com.luan.teste.presentation.emoji.EmojiListViewModel
import com.luan.teste.presentation.profile.ProfileViewModel
import com.luan.teste.presentation.profile.search.ProfileSearchView
import com.luan.teste.presentation.repositories.RepoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val modules = module {
        viewModel { EmojiListViewModel(get()) }
        viewModel { RepoListViewModel(get()) }
        viewModel { ProfileViewModel(get(),get()) }
    }
}