package com.example.dagger2.di.providers

import com.example.dagger2.di.qualifiers.MessageNotifyQualifier
import com.example.dagger2.di.qualifiers.SQLDatabaseQualifier
import com.example.dagger2.di.scopes.ActivityScope
import com.example.dagger2.domain.repositories.UserRepository
import com.example.dagger2.presentation.service.NotificationService
import com.example.dagger2.presentation.service.UserRegistrationService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepoModule {

//    @Binds
//    abstract fun bindUserRepository(userRepository: UserRepository): SQLUserRepository
//
//    @Binds
//    abstract fun bindNotificationRepository(notificationService: NotificationService): MessageNotifyQualifier

    @Provides
    @ActivityScope
    fun provideUserRegistrationService(
        @MessageNotifyQualifier notificationService: NotificationService,
        @SQLDatabaseQualifier userRepository: UserRepository
    ): UserRegistrationService {
        return UserRegistrationService(notificationService, userRepository)
    }

}

