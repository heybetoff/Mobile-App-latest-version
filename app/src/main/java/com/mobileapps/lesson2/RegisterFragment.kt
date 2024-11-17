package com.mobileapps.lesson2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment() {

    private lateinit var credentialsManager: CredentialsManager
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_register, container, false)


        emailEditText = binding.findViewById(R.id.emailEditText)
        passwordEditText = binding.findViewById(R.id.passwordEditText)
        confirmPasswordEditText = binding.findViewById(R.id.confirmPasswordEditText)
        registerButton = binding.findViewById(R.id.registerButton)
        loginButton = binding.findViewById(R.id.loginButton)


        //credentialsManager = (activity as MainActivity).getCredentialsManager()


        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (password == confirmPassword) {
                if (credentialsManager.isEmailValid(email) && credentialsManager.isPasswordValid(password)) {
                    val result = credentialsManager.register(email, password)
                    Toast.makeText(context, result, Toast.LENGTH_SHORT).show()


                    val transaction = parentFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainer, LoginFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                } else {
                    Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }


        loginButton.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, LoginFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return binding
    }
}
