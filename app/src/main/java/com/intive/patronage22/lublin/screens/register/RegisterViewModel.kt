package com.intive.patronage22.lublin.screens.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intive.patronage22.lublin.RegisterFlowValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerFlowValidator: RegisterFlowValidator
) : ViewModel() {

    private val _usernameValidationResult = MutableLiveData<String>()
    val usernameValidationResult: LiveData<String> = _usernameValidationResult

    private val _passwordValidationResult = MutableLiveData<String>()
    val passwordValidationResult: LiveData<String> = _passwordValidationResult

    private val _emailValidationResult = MutableLiveData<String>()
    val emailValidationResult: LiveData<String> = _emailValidationResult

    fun onUsernameChanged(username: String) {
        _usernameValidationResult.value = registerFlowValidator.validateUsername(username)
    }

    fun onPasswordChanged(password: String) {
        _passwordValidationResult.value = registerFlowValidator.validatePassword(password)
    }

    fun onEmailChanged(email: String) {
        _emailValidationResult.value = registerFlowValidator.validateEmail(email)
    }
}
