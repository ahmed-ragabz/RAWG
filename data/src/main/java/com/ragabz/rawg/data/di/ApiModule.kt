package com.ragabz.rawg.data.di

import com.ragabz.rawg.data.datasource.remote.api.RawgApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    /**
     * function use injected reference from retrofit
     * to create object from [RawgApi]
     * @param retrofit
     * @return [RawgApi]
     */
    @Provides
    @Singleton
    fun provideRawgApi(retrofit: Retrofit): RawgApi {
        return retrofit.create(RawgApi::class.java)
    }

}
