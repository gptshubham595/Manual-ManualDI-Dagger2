package com.example.dagger2.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.dagger2.di.component.DaggerUserRegistrationServiceComponent
import com.example.dagger2.presentation.service.EmailService
import com.example.dagger2.presentation.service.UserRegistrationService
import com.example.manual.MainApplication
import com.example.manualdi.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    lateinit var emailService1: EmailService
    lateinit var emailService2: EmailService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text = "Dagger 2"

        val daggerComponent = DaggerUserRegistrationServiceComponent.factory().create(3, MainApplication().appComponent)//.builder()
//            .notificationServiceModule(NotificationServiceModule(3))
//            .build()
        emailService1 = daggerComponent.getEmailService()
        daggerComponent.inject(this)

//        val daggerComponent2 =
//            DaggerUserRegistrationServiceComponent.factory().create(3, MainApplication().appComponent)//.builder()
//            .notificationServiceModule(NotificationServiceModule(3))
//            .build()
//        emailService2 = daggerComponent2.getEmailService()

//        binding.text += "\nEmailService1 : ${emailService1.hashCode()}"
//        binding.text += "\nEmailService2 : ${emailService2.hashCode()}"

        lifecycleScope.launch {
            userRegistrationService.registerUser(
                "john.c.calhoun@examplepetstore.com", "password123"
            ).collect {
                binding.text += "\n$it"
            }
        }

    }

}