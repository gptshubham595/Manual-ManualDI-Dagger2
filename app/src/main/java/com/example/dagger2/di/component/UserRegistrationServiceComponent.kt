package com.example.dagger2.di.component

import com.example.dagger2.di.providers.NotificationServiceModule
import com.example.dagger2.di.providers.RepoModule
import com.example.dagger2.di.providers.UserRepositoryModule
import com.example.dagger2.di.scopes.ActivityScope
import com.example.dagger2.presentation.service.EmailService
import com.example.dagger2.presentation.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [RepoModule::class,
        NotificationServiceModule::class,
        UserRepositoryModule::class]
)
interface UserRegistrationServiceComponent {
//    fun getUserRegistrationService(): UserRegistrationService

    fun inject(mainActivity: MainActivity)

    fun getEmailService(): EmailService

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance retryCount: Int,
            appComponent: AppComponent
        ): UserRegistrationServiceComponent
    }
}