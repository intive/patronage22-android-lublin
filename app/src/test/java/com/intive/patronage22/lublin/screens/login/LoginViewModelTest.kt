package com.intive.patronage22.lublin.screens.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.patronage22.lublin.RegisterFlowValidator
import com.intive.patronage22.lublin.screens.TestValidationResults.Companion.VALIDATION_ERROR
import com.intive.patronage22.lublin.screens.TestValidationResults.Companion.VALIDATION_OK
import com.intive.patronage22.lublin.screens.TestValidationResults.Companion.createLoginValidationResult
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.amshove.kluent.`should be`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(JUnitParamsRunner::class)
class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val validationResult = "validation result"
    private val username = "username"
    private val password = "password"

    private val validator: RegisterFlowValidator = mock {
        on { validateUsername(username) } doReturn validationResult
        on { validatePassword(password) } doReturn validationResult
    }

    private val tested by lazy { LoginViewModel(validator) }

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
    @Parameters(method = "testParams")
    @TestCaseName("given usernameValidationResult = {0}, passwordValidationResult = {1} when form validated then loginButtonEnabled = {2}")
    fun `given validation results when login form fields changes then login button has proper state`(
        usernameValidationResult: String?,
        passwordValidationResult: String?,
        result: String?
    ) {
        whenever(validator.validatePassword(password)).doReturn(passwordValidationResult)
        whenever(validator.validateUsername(username)).doReturn(usernameValidationResult)

        tested.onPasswordChanged(password)
        tested.onUsernameChanged(username)

        tested.loginButtonEnabled.value `should be` result.toBoolean()
    }

    private fun testParams() =
            listOf(
                createLoginValidationResult(
                    usernameValidationResult = VALIDATION_OK,
                    passwordValidationResult = VALIDATION_OK,
                    buttonEnabled = true
                ),
                createLoginValidationResult(
                    usernameValidationResult = VALIDATION_ERROR,
                    passwordValidationResult = VALIDATION_OK,
                    buttonEnabled = false
                ),
                createLoginValidationResult(
                    usernameValidationResult = VALIDATION_OK,
                    passwordValidationResult = VALIDATION_ERROR,
                    buttonEnabled = false
                ),
                createLoginValidationResult(
                    usernameValidationResult = VALIDATION_ERROR,
                    passwordValidationResult = VALIDATION_ERROR,
                    buttonEnabled = false
                )
            )
}