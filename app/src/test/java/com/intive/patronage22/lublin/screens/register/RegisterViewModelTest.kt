package com.intive.patronage22.lublin.screens.register

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.patronage22.lublin.RegisterFlowValidator
import com.intive.patronage22.lublin.screens.TestValidationResults.Companion.VALIDATION_ERROR
import com.intive.patronage22.lublin.screens.TestValidationResults.Companion.VALIDATION_OK
import com.intive.patronage22.lublin.screens.TestValidationResults.Companion.createRegistrationValidationResult
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
class RegisterViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val validationResult = "validation result"
    private val username = "username"
    private val password = "password"
    private val email = "email"

    private val validator: RegisterFlowValidator = mock {
        on { validateUsername(username) } doReturn validationResult
        on { validatePassword(password) } doReturn validationResult
        on { validateEmail(email) } doReturn validationResult
    }
    private val signup: SignUpUseCase = mock()

    private val tested by lazy { RegisterViewModel(validator, signup) }

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

    @Test
    @Parameters(method = "testParams")
    @TestCaseName("given usernameValidationResult = {0}, emailValidationResult = {1}, passwordValidationResult = {2} when form validated then registerButtonEnabled = {3}")
    fun `given validation results when registration form fields changes then registration button has proper state`(
        usernameValidationResult: String?,
        emailValidationResult: String?,
        passwordValidationResult: String?,
        result: String?
    ) {
        whenever(validator.validateEmail(email)).doReturn(emailValidationResult)
        whenever(validator.validatePassword(password)).doReturn(passwordValidationResult)
        whenever(validator.validateUsername(username)).doReturn(usernameValidationResult)

        tested.onEmailChanged(email)
        tested.onPasswordChanged(password)
        tested.onUsernameChanged(username)

        tested.registerButtonEnabled.value `should be` result.toBoolean()
    }

    private fun testParams() =
        listOf(
            createRegistrationValidationResult(
                usernameValidationResult = VALIDATION_OK,
                emailValidationResult = VALIDATION_OK,
                passwordValidationResult = VALIDATION_OK,
                buttonEnabled = true
            ),
            createRegistrationValidationResult(
                usernameValidationResult = VALIDATION_ERROR,
                emailValidationResult = VALIDATION_OK,
                passwordValidationResult = VALIDATION_OK,
                buttonEnabled = false
            ),
            createRegistrationValidationResult(
                usernameValidationResult = VALIDATION_OK,
                emailValidationResult = VALIDATION_ERROR,
                passwordValidationResult = VALIDATION_OK,
                buttonEnabled = false
            ),
            createRegistrationValidationResult(
                usernameValidationResult = VALIDATION_OK,
                emailValidationResult = VALIDATION_OK,
                passwordValidationResult = VALIDATION_ERROR,
                buttonEnabled = false
            ),
            createRegistrationValidationResult(
                usernameValidationResult = VALIDATION_ERROR,
                emailValidationResult = VALIDATION_ERROR,
                passwordValidationResult = VALIDATION_ERROR,
                buttonEnabled = false
            )
        )
}