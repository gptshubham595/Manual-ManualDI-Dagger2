package com.example.dagger2.presentation.service

import com.example.dagger2.di.scopes.ActivityScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService {
    fun notifyUser(email: String, message: String): Flow<String>
}

@ActivityScope
class EmailService @Inject constructor() : NotificationService {
    override fun notifyUser(email: String, message: String): Flow<String> = flow {
        emit("\nEmail sent to $email with message: $message")
    }
}

@ActivityScope
class MessageService @Inject constructor(val retryCount: Int) : NotificationService {
    override fun notifyUser(email: String, message: String): Flow<String> = flow {
        emit("\nMessage sent to $email with message: $message with retry count: $retryCount")
    }
}