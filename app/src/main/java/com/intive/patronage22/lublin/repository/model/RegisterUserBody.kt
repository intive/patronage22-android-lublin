package com.intive.patronage22.lublin.repository.model

import com.google.gson.annotations.SerializedName

data class RegisterUserBody(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)