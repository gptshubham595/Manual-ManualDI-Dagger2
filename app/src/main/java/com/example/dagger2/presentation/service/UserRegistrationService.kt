package com.example.dagger2.presentation.service

import com.example.dagger2.di.qualifiers.MessageNotifyQualifier
import com.example.dagger2.di.qualifiers.SQLDatabaseQualifier
import com.example.dagger2.domain.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    @MessageNotifyQualifier private val notificationService: NotificationService,
    @SQLDatabaseQualifier private val userRepository: UserRepository
) {

    fun registerUser(email: String, password: String): Flow<String> = channelFlow {
            launch {
                userRepository.saveUser(email, password).collect {
                    trySend(it)
                }
            }
            launch {
                notificationService.notifyUser(
                    email,
                    "You have successfully registered with email: $email"
                ).collect {
                    trySend(it)
                }
            }
    }
}
