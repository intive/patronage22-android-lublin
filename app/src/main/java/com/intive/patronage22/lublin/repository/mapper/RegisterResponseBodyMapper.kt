package com.intive.patronage22.lublin.repository.mapper

import android.util.Log
import com.intive.patronage22.lublin.repository.model.registration.RegisterResponseBody
import com.intive.patronage22.lublin.repository.model.registration.SignUpException
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class RegisterResponseBodyMapper @Inject constructor() {

    fun map(input: Response<RegisterResponseBody>) {
        Log.d("response body: ", input.toString())
        val jsonObj = JSONObject(input.errorBody()!!.charStream().readText())
        val takeErrors = jsonObj.getJSONArray("errors")
        Log.d("response body as jsonObj: ", takeErrors.toString())

        if (input.body() == null) {
            Log.d("error", " no body in input")
            when (input.errorBody().toString()) {
                "Invalid username" -> throw SignUpException(SignUpException.INVALID_USERNAME)
                "Email already exist!" -> {
                    //throw SignUpException(SignUpException.INVALID_EMAIL_EXIST)
                    Log.d("email", " already exist")
                }
                "Invalid email address!" -> throw SignUpException(SignUpException.INVALID_EMAIL)
                "Invalid password" -> throw SignUpException(SignUpException.INVALID_PASSWORD)
                else -> {
                    throw SignUpException(SignUpException.UNKNOWN_EXCEPTION)
                }

            }
        }
    }
}