package com.example.dagger2.presentation.service

import javax.inject.Inject

interface AnalyticsService {

    fun logEvent(event: String) {
        println("Event: $event")
    }
}

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService{
    override fun logEvent(event: String) {
        println("Event: $event")
    }
}