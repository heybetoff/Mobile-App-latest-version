package com.mobileapps.lesson2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    private lateinit var credentialsManager: CredentialsManager
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize UI elements
        emailEditText = binding.findViewById(R.id.emailEditText)
        passwordEditText = binding.findViewById(R.id.passwordEditText)
        loginButton = binding.findViewById(R.id.loginButton)
        registerButton = binding.findViewById(R.id.registerButton)


       // credentialsManager = (activity as MainActivity).getCredentialsManager()


        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (credentialsManager.isEmailValid(email) && credentialsManager.isPasswordValid(password)) {
                val storedEmail = credentialsManager.getStoredEmail()
                val storedPassword = credentialsManager.getStoredPassword()

                if (email == storedEmail && password == storedPassword) {
                    Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }


        registerButton.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, RegisterFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return binding
    }
}
