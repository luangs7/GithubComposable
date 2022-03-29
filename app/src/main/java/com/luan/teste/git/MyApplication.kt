package com.luan.teste.git

import android.app.Application
import com.luan.teste.data.local.di.DataLocalRemote
import com.luan.teste.data.remote.di.DataRemoteModule
import com.luan.teste.data.remote.di.NetworkModule
import com.luan.teste.data.repository.di.RepositoryModule
import com.luan.teste.domain.di.DomainModule
import com.luan.teste.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            androidLogger(Level.DEBUG)
            modules(
                NetworkModule.modules +
                        DataLocalRemote.modules +
                        DataRemoteModule.modules +
                        RepositoryModule.modules +
                        DomainModule.modules +
                        PresentationModule.modules
            )
        }
    }
}