package com.intive.patronage22.lublin.screens.register

import com.intive.patronage22.lublin.data.api.PatronageService
import com.intive.patronage22.lublin.repository.model.RegisterUserBody
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val patronageService: PatronageService
) {
    suspend fun execute(
        name: String,
        email: String,
        password: String
    ) {
        val registerUserBody = RegisterUserBody(name, email, password)
        patronageService.registerUser(registerUserBody)
    }
}