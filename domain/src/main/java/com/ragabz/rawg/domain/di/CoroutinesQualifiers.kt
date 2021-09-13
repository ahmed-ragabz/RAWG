package com.ragabz.rawg.domain.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class DefaultDispatcher


@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class IODispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class MainDispatcher


@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class MainImmediateDispatcher

