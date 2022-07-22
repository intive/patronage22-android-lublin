package com.intive.patronage22.lublin.screens.register

import com.intive.patronage22.lublin.data.repository.RegistrationRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val registrationRepository: RegistrationRepository
) {
    suspend fun execute(
        name: String,
        email: String,
        password: String
    ) {
        registrationRepository.getResponseBody(name, email, password)
    }
}