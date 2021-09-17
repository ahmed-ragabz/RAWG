package com.ragabz.rawg.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.moczul.ok2curl.CurlInterceptor
import com.ragabz.rawg.data.BuildConfig
import com.ragabz.rawg.data.datasource.remote.api.AuthInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
object NetworkModule {

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


    @Singleton
    @Provides
    fun bindAuthInterceptor(): AuthInterceptor = AuthInterceptor()

    /**
     * provide OkHttpClient
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
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
            addInterceptor(authInterceptor)
            connectTimeout(TIME_OUT, TimeUnit.MINUTES)
            readTimeout(TIME_OUT, TimeUnit.MINUTES)
            writeTimeout(TIME_OUT, TimeUnit.MINUTES)
            retryOnConnectionFailure(true)
        }.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .serializeNulls() // to allow sending null values
            .create()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    /**
     * provide retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
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
