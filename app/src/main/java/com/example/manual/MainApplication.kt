package com.example.manual

import android.app.Application
import com.example.dagger2.di.component.AppComponent
import com.example.dagger2.di.component.DaggerAppComponent
import com.example.dagger2.di.component.DaggerUserRegistrationServiceComponent
import com.example.dagger2.di.component.UserRegistrationServiceComponent

class MainApplication : Application() {

//    lateinit var userRegistrationServiceComponent: UserRegistrationServiceComponent
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}