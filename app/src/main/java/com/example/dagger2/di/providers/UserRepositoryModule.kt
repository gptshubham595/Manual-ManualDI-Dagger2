package com.example.dagger2.di.providers

import com.example.dagger2.di.component.AppComponent
import com.example.dagger2.di.qualifiers.FirebaseDatabaseQualifier
import com.example.dagger2.di.qualifiers.SQLDatabaseQualifier
import com.example.dagger2.di.scopes.ActivityScope
import com.example.dagger2.domain.repositories.SQLUserRepository
import com.example.dagger2.domain.repositories.UserRepository
import com.example.dagger2.presentation.service.AnalyticsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UserRepositoryModule {


    @Provides
    @ActivityScope
    @SQLDatabaseQualifier
    fun provideSQLUserRepository(analyticsService: AnalyticsService): UserRepository {
        return SQLUserRepository(analyticsService)
    }

    @Provides
    @ActivityScope
    @FirebaseDatabaseQualifier
    fun provideFirebaseUserRepository(analyticsService: AnalyticsService): UserRepository {
        return SQLUserRepository(analyticsService)
    }

}