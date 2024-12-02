package com.example.dagger2.di.component

import com.example.dagger2.di.providers.AnalyticsModule
import com.example.dagger2.di.scopes.ApplicationScope
import com.example.dagger2.presentation.service.AnalyticsService
import dagger.Component

@ApplicationScope
@Component(
    modules = [AnalyticsModule::class]
)
interface AppComponent {
    fun getAnalyticsService(): AnalyticsService
}