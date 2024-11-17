package com.mobileapps.lesson2

import android.content.Context
import android.content.SharedPreferences

class CredentialsManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)


    fun register(email: String, password: String): String {
        val editor = sharedPreferences.edit()
        editor.putString("user_email", email)
        editor.putString("user_password", password)
        editor.apply()
        return "Success"
    }


    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }


    fun getStoredEmail(): String? {
        return sharedPreferences.getString("user_email", null)
    }

    fun getStoredPassword(): String? {
        return sharedPreferences.getString("user_password", null)
    }
}
