package com.example.manualdi.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manualdi.domain.repositories.UserRepository
import com.example.manualdi.presentation.service.EmailService
import com.example.manualdi.presentation.service.UserRegistrationService
import com.example.manualdi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userRegistrationService = UserRegistrationService(
            EmailService(),
            UserRepository()
        )
        userRegistrationService.registerUser("john.c.calhoun@examplepetstore.com", "password123")

    }

}