package com.example.dagger2.domain.repositories

import com.example.dagger2.di.scopes.ActivityScope
import com.example.dagger2.presentation.service.AnalyticsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface UserRepository {
    fun saveUser(email: String, password: String): Flow<String>
}

@ActivityScope
class SQLUserRepository @Inject constructor(private val analyticsService: AnalyticsService) :
    UserRepository {
    override fun saveUser(email: String, password: String): Flow<String> = flow {
        analyticsService.logEvent("User saved")
        emit("\nSQL: User saved with email: $email and password: $password")
    }
}

@ActivityScope
class FirebaseUserRepository @Inject constructor(private val analyticsService: AnalyticsService) :
    UserRepository {
    override fun saveUser(email: String, password: String): Flow<String> = flow {
        analyticsService.logEvent("User saved")
        emit("\nFirebase: User saved with email: $email and password: $password")
    }
}