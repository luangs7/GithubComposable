package com.luan.teste.data.remote.di

import com.luan.teste.data.remote.emoji.datasource.EmojiRemoteDataSourceImpl
import com.luan.teste.data.remote.emoji.service.EmojiService
import com.luan.teste.data.remote.emoji.service.EmojiServiceMock
import com.luan.teste.data.remote.profile.datasource.ProfileDataSourceImpl
import com.luan.teste.data.remote.profile.service.ProfileService
import com.luan.teste.data.remote.profile.service.ProfileServiceMock
import com.luan.teste.data.remote.repositories.datasource.RepositoriesDataSourceImpl
import com.luan.teste.data.remote.repositories.service.RepositoriesService
import com.luan.teste.data.remote.repositories.service.RepositoriesServiceMock
import com.luan.teste.data.remote.utils.resolveRetrofit
import com.luan.teste.data.repository.emoji.datasource.EmojiRemoteDataSource
import com.luan.teste.data.repository.profile.datasource.ProfileDataSource
import com.luan.teste.data.repository.repositories.datasource.RepositoriesDataSource
import org.koin.dsl.module

object DataRemoteModule {

    val modules = module {
        single<EmojiRemoteDataSource> { EmojiRemoteDataSourceImpl(get()) }
        single<ProfileDataSource> { ProfileDataSourceImpl(get()) }
        single<RepositoriesDataSource> { RepositoriesDataSourceImpl(get()) }

        single<EmojiService> { resolveRetrofit() ?: EmojiServiceMock() }
        single<ProfileService> { resolveRetrofit() ?: ProfileServiceMock() }
        single<RepositoriesService> { resolveRetrofit() ?: RepositoriesServiceMock() }

    }


}