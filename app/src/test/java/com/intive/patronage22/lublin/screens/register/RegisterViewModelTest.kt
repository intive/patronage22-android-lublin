package com.intive.patronage22.lublin.screens.register

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.patronage22.lublin.RegisterFlowValidator
import org.amshove.kluent.`should be`
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class RegisterViewModelTest {

    private val validationResult = "validation result"
    private val username = "username"
    private val password = "password"
    private val email = "email"

    private val tested by lazy { RegisterViewModel(validator) }

    private val validator: RegisterFlowValidator = mock {
        on { validateUsername(username) } doReturn validationResult
        on { validatePassword(password) } doReturn validationResult
        on { validateEmail(email) } doReturn validationResult
    }

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `given username when onUsernameChanged called then return validation result`() {
        tested.onUsernameChanged(username)

        tested.usernameValidationResult.value `should be` "validation result"
    }

    @Test
    fun `given password when onPasswordChanged called then return validation result`() {
        tested.onPasswordChanged(password)

        tested.passwordValidationResult.value `should be` "validation result"
    }

    @Test
    fun `given email when onEmailChanged called then return validation result`() {
        tested.onEmailChanged(email)

        tested.emailValidationResult.value `should be` "validation result"
    }
}