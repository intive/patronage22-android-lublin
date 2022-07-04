package com.intive.patronage22.lublin.screens.register

data class FormValidationResults(
    val correctUsername: String? = null,
    val correctPassword: String? = null,
    val correctEmail: String? = null,
    val incorrectUsername: String? = "error message",
    val incorrectPassword: String? = "error message",
    val incorrectEmail: String? = "error message",
    val buttonEnabled: Boolean = true,
    val buttonDisabled: Boolean = false
)