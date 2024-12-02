package com.example.manualdi.presentation.service

import com.example.manualdi.domain.repositories.UserRepository

class UserRegistrationService constructor(
    private val emailService: EmailService,
    private val userRepository: UserRepository
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.sendEmail(
            email,
            "Welcome to our app",
            "You have successfully registered with email: $email"
        )
    }
}

/***
 * Manual DI
 * Unit testing is difficult in this class as we are creating instances of EmailService and UserRepository
 * inside the class. We can't mock these instances in the test class.
 *
 * Single Responsibility Principle is violated as this class is responsible for creating instances too
 *
 * Lifetime of Objects: EmailService and UserRepository are created/die every time UserRegistrationService is created
 *
 * Extensible: If we want to change the implementation of EmailService or UserRepository, we need to change the code
 */