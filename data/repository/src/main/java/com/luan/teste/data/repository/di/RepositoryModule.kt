package com.luan.teste.data.repository.di

import com.luan.teste.data.repository.emoji.implementation.EmojiRepositoryImpl
import com.luan.teste.data.repository.profile.implementation.ProfileRepositoryImpl
import com.luan.teste.data.repository.repositories.implementation.RepositoriesRepositoryImpl
import com.luan.teste.domain.repository.EmojiRepository
import com.luan.teste.domain.repository.ProfileRepository
import com.luan.teste.domain.repository.RepositoriesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

object RepositoryModule {

    val modules = module {
        factory<EmojiRepository> { EmojiRepositoryImpl(get(),get()) }
        factory<RepositoriesRepository> { RepositoriesRepositoryImpl(get(), get()) }
        factory<ProfileRepository> { ProfileRepositoryImpl(get(), get()) }

        factory { CoroutineScope(Dispatchers.IO) }

    }
}