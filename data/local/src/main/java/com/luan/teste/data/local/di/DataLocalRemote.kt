package com.luan.teste.data.local.di

import android.content.Context
import androidx.room.Room
import com.luan.teste.data.local.dao.EmojiDao
import com.luan.teste.data.local.dao.GitDatabase
import com.luan.teste.data.local.emoji.datasource.EmojiLocalDataSourceImpl
import com.luan.teste.data.repository.emoji.datasource.EmojiLocalDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DataLocalRemote {

    val modules = module {

        fun provideDatabase(application: Context): GitDatabase {
            return Room.databaseBuilder(
                application,
                GitDatabase::class.java,
                GitDatabase.EMOJI_TABLE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        fun provideDao(database: GitDatabase): EmojiDao {
            return database.emojiDao
        }

        single { provideDatabase(androidContext()) }

        single { provideDao(get()) }

        single<EmojiLocalDataSource>{ EmojiLocalDataSourceImpl(get()) }
    }
}