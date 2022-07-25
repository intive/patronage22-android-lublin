package com.intive.patronage22.lublin.repository.mapper

import android.util.Log
import com.intive.patronage22.lublin.repository.model.registration.RegisterErrorMassages
import com.intive.patronage22.lublin.repository.model.registration.RegisterResponseBody
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class RegisterResponseBodyMapper @Inject constructor() {
    var enumState: Enum<RegisterErrorMassages>? = null

    fun map(input: Response<RegisterResponseBody>) {
        Log.d("Response body: ", input.toString())
        if (input.body() == null) {
            Log.d("error body: ", input.errorBody()!!.charStream().readText())
            val msg = JSONObject(input.errorBody()!!.charStream().readText()).getJSONArray("errors")
                .getJSONObject(0).getString("msg")
            Log.d("error: ", msg)
            when (msg) {
                "Invalid email address!" -> enumState = RegisterErrorMassages.INVALID_EMAIL
                "Email already exist!" -> enumState = RegisterErrorMassages.EMAIL_ALREADY_EXIST
            }
            throw SignUpException(enumState.toString())
        }
    }
}

class SignUpException(private val massage: String) : java.lang.Exception(massage)