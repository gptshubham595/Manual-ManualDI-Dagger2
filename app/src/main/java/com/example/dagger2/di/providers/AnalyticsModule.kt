package com.example.dagger2.di.providers

import com.example.dagger2.di.scopes.ApplicationScope
import com.example.dagger2.presentation.service.AnalyticsService
import com.example.dagger2.presentation.service.AnalyticsServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AnalyticsModule {

    @ApplicationScope
    @Binds
    abstract fun provideAnalyticsService(analyticsServiceImpl: AnalyticsServiceImpl): AnalyticsService
}