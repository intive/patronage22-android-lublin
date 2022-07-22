package com.intive.patronage22.lublin.repository.model.registration

class SignUpException(val errorCode: Int) : java.lang.Exception() {
    companion object {
        const val INVALID_USERNAME = 10
        const val INVALID_EMAIL = 21
        const val INVALID_EMAIL_EXIST = 22
        const val INVALID_PASSWORD = 30
        const val UNKNOWN_EXCEPTION = 100
    }
}