package com.luan.teste.domain.di

import com.luan.teste.domain.interactor.*
import org.koin.dsl.module

object DomainModule {

    val modules = module {
        factory<GetEmojiListUseCase> { GetEmojiListUseCaseImpl(get()) }
        factory<GetRepositoriesUseCase> { GetRepositoriesUseCaseImpl(get()) }
        factory<GetUserByNameUseCase> { GetUserByNameUseCaseImpl(get()) }
        factory<GetUserUseCase> { GetUserUseCaseImpl(get()) }
    }
}