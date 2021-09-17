package com.ragabz.rawg.data.di


import com.ragabz.rawg.data.datasource.local.daos.GamesDao
import com.ragabz.rawg.data.datasource.remote.api.RawgApi
import com.ragabz.rawg.data.repositories.GamesRepositoryImpl
import com.ragabz.rawg.domain.repositories.GamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGameRepository( dao: GamesDao, rawgApi: RawgApi): GamesRepository = GamesRepositoryImpl(dao,rawgApi)
}