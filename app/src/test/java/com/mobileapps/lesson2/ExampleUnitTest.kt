package com.mobileapps.lesson2

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ExampleUnitTest {

    private lateinit var credentialsManager: CredentialsManager

    @Before
    fun setup() {
        credentialsManager = CredentialsManager()
    }

    @Test
    fun `email should be invalid when empty`() {
        assertFalse(credentialsManager.isEmailValid(""))
    }

    @Test
    fun `email should be invalid when null`() {
        assertFalse(credentialsManager.isEmailValid(NULL))
    }

    @Test
    fun `email should be invalid when format is wrong`() {
        assertFalse(credentialsManager.isEmailValid("invalid-email"))
        assertFalse(credentialsManager.isEmailValid("example@com"))
        assertFalse(credentialsManager.isEmailValid("example.com"))
    }

    @Test
    fun `email should be valid when properly formatted`() {
        assertTrue(credentialsManager.isEmailValid("example@example.com"))
        assertTrue(credentialsManager.isEmailValid("user.name+tag+sorting@example.com"))
    }

    @Test
    fun `password should be invalid when empty`() {
        assertFalse(credentialsManager.isPasswordValid(""))
    }

    @Test
    fun `password should be invalid when null`() {
        assertFalse(credentialsManager.isPasswordValid(NULL))
    }

    @Test
    fun `password should be valid when not empty`() {
        assertTrue(credentialsManager.isPasswordValid("password123"))
    }
}
