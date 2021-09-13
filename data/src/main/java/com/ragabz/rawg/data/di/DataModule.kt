package com.ragabz.rawg.data.di

import android.content.Context
import com.ragabz.rawg.data.datasource.local.daos.GamesDao
import com.ragabz.rawg.data.datasource.local.db.RawgDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RawgDataBase {
        return RawgDataBase.instance(context)
    }

    @Singleton
    @Provides
    fun provideGamesDao(rawgDataBase: RawgDataBase) : GamesDao = rawgDataBase.gamesDao()
}