package com.example.manual.presentation.service

class EmailService {
    fun sendEmail(email: String, subject: String, message: String) {
        println("Email sent to $email with subject: $subject and message: $message")
    }
}