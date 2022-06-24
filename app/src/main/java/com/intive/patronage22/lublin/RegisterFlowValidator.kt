package com.intive.patronage22.lublin

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RegisterFlowValidator @Inject constructor(@ApplicationContext var appContext: Context) {

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
        } else {
            appContext.getString(R.string.not_valid_username_error)
        }
    }

    fun validatePassword(password: String): String? {
        return if (passwordRegex.matches(password)) {
            null
        } else {
            appContext.getString(R.string.not_valid_password_error)
        }
    }

    fun validateEmail(email: String): String? {
        return if (emailRegex.matches(email)) {
            null
        } else {
            appContext.getString(R.string.not_valid_email_error)
        }
    }
}