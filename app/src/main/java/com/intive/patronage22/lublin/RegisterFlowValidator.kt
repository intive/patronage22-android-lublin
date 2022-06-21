package com.intive.patronage22.lublin

import javax.inject.Inject

class RegisterFlowValidator @Inject constructor() {
    // TODO to string resource
    private val passwordPolicy =
        "password should contain at least 6 characters including letters," +
                " numbers nad special character"
    private val usernamePolicy =
        "user name should not contains any special characters(no spaces)"

    private val wrongNameMessage = "Enter a valid name"
    private val wrongEmailMessage = "Enter a valid email address"
    private val wrongPasswordMessage = "Enter a valid password"

    private val emailRegex =
        Regex("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ0-9]+@[a-z]+\\.[a-z]+")
    private val passwordRegex =
        Regex(
            "^(?=.+[0-9])(?=.+[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ])(?=.+[@$!%*#?&])" +
                    "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ0123456789@$!%*#?&]{6,}\$"
        )
    private val usernameRegex =
        Regex("^[A-Za-z0-9]+\$")

    fun validateUsername(username: String): String? {
        return if (usernameRegex.matches(username)) {
            null
        } else wrongNameMessage
    }

    private fun validatePassword(password: String): String? {
        return if (passwordRegex.matches(password)) {
            null
        } else wrongPasswordMessage
    }

    private fun validateEmail(email: String): String? {
        return if (emailRegex.matches(email)) {
            null
        } else wrongEmailMessage
    }
}