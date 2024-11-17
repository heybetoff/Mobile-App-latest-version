package com.mobileapps.lesson2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AccountActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var nextButton: Button
    private lateinit var registerNowTextView: TextView

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        credentialsManager = CredentialsManager(this)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        nextButton = findViewById(R.id.nextButton)
        registerNowTextView = findViewById(R.id.registerNowTextView)


        nextButton.setOnClickListener { validateLogin() }
        registerNowTextView.setOnClickListener { navigateToSignUp() }
    }

    private fun validateLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        val storedEmail = credentialsManager.getStoredEmail()
        val storedPassword = credentialsManager.getStoredPassword()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            return
        }

        if (email != storedEmail || password != storedPassword) {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            return
        }

        // Successful login
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

    }

    private fun navigateToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
