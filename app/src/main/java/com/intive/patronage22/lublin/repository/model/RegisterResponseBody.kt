package com.intive.patronage22.lublin.repository.model

import com.google.gson.annotations.SerializedName

data class RegisterResponseBody(
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("token")
    val token: String?
)