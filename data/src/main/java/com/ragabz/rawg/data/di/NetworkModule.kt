package com.ragabz.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.moczul.ok2curl.CurlInterceptor
import com.ragabz.rawg.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val TIME_OUT = 2L
private const val CHUCKER_MAX_CONTENT = 250000L


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /**
     * provide HttploggingInterceptor
     */
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOk2CurlInterceptor(): CurlInterceptor {
        return CurlInterceptor { message -> Timber.v("Ok2Curl $message") }
    }

    /**
     * provide OkHttpClient
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        curlInterceptor: CurlInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(curlInterceptor)
                addInterceptor(chuckerInterceptor)
                addInterceptor(loggingInterceptor)
            }
            connectTimeout(TIME_OUT, TimeUnit.MINUTES)
            readTimeout(TIME_OUT, TimeUnit.MINUTES)
            writeTimeout(TIME_OUT, TimeUnit.MINUTES)
            retryOnConnectionFailure(true)
        }.build()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    /**
     * provide retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient)
            .build()
    }

    /**
     * provide chucker interceptor
     */
    @Provides
    @Singleton
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .maxContentLength(CHUCKER_MAX_CONTENT)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()
    }
}
