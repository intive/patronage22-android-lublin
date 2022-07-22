package com.intive.patronage22.lublin.data.repository

import com.intive.patronage22.lublin.data.api.PatronageService
import com.intive.patronage22.lublin.repository.mapper.RegisterResponseBodyMapper
import com.intive.patronage22.lublin.repository.model.registration.RegisterUserBody
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val patronageService: PatronageService,
    private val registerResponseBodyMapper: RegisterResponseBodyMapper
) {

    suspend fun getResponseBody(name: String, email: String, password: String) {
        val registerUserBody = RegisterUserBody(name, email, password)
        registerResponseBodyMapper.map(patronageService.registerUser(registerUserBody))
    }
}