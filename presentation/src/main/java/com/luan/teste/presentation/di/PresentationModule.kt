package com.luan.teste.presentation.di

import com.luan.teste.presentation.emoji.EmojiListViewModel
import com.luan.teste.presentation.repositories.RepoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val modules = module {
        viewModel { EmojiListViewModel(get()) }
        viewModel { RepoListViewModel(get()) }
    }
}