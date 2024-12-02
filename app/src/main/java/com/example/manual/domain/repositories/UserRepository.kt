package com.example.manual.domain.repositories

class UserRepository {
    fun saveUser(email: String, password: String) {
        println("User saved with email: $email and password: $password")
    }
}