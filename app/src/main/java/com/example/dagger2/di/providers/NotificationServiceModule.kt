package com.example.dagger2.di.providers

import com.example.dagger2.di.qualifiers.EmailNotifyQualifier
import com.example.dagger2.di.qualifiers.MessageNotifyQualifier
import com.example.dagger2.di.scopes.ActivityScope
import com.example.dagger2.presentation.service.EmailService
import com.example.dagger2.presentation.service.MessageService
import com.example.dagger2.presentation.service.NotificationService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NotificationServiceModule() {

    @Provides
    @ActivityScope
//    @Named("email")
    @EmailNotifyQualifier
    fun provideEmailNotificationService(): NotificationService {
        return EmailService()
    }

    @Provides
    @ActivityScope
    @MessageNotifyQualifier
    fun provideMessageNotificationService(retryCount2: Int): NotificationService {
        return MessageService(retryCount2)
    }


}