package com.intive.patronage22.lublin.screens

class TestValidationResults {
    companion object {

        val VALIDATION_OK: String? = null
        const val VALIDATION_ERROR: String = "not null response equals error state"

        fun createRegistrationValidationResult(
            usernameValidationResult: String?,
            emailValidationResult: String?,
            passwordValidationResult: String?,
            buttonEnabled: Boolean
        ) =
            arrayOf(usernameValidationResult, emailValidationResult, passwordValidationResult, buttonEnabled)

        fun createLoginValidationResult(
            usernameValidationResult: String?,
            passwordValidationResult: String?,
            buttonEnabled: Boolean
        ) =
            arrayOf(usernameValidationResult, passwordValidationResult, buttonEnabled)
    }
}