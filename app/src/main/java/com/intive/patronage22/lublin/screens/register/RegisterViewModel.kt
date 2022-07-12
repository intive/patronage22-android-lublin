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

    private var usernameCorrect = false
    private var passwordCorrect = false
    private var emailCorrect = false

    private var _registerButtonEnabled = MutableLiveData<Boolean>(false)
    val registerButtonEnabled: LiveData<Boolean> = _registerButtonEnabled

    private val _usernameValidationResult = MutableLiveData<String>()
    val usernameValidationResult: LiveData<String> = _usernameValidationResult

    private val _passwordValidationResult = MutableLiveData<String>()
    val passwordValidationResult: LiveData<String> = _passwordValidationResult

    private val _emailValidationResult = MutableLiveData<String>()
    val emailValidationResult: LiveData<String> = _emailValidationResult

    fun onUsernameChanged(username: String) {
        _usernameValidationResult.value = registerFlowValidator.validateUsername(username)
        usernameCorrect = _usernameValidationResult.value == null
        enableRegisterButton()
    }

    fun onPasswordChanged(password: String) {
        _passwordValidationResult.value = registerFlowValidator.validatePassword(password)
        passwordCorrect = _passwordValidationResult.value == null
        enableRegisterButton()
    }

    fun onEmailChanged(email: String) {
        _emailValidationResult.value = registerFlowValidator.validateEmail(email)
        emailCorrect = emailValidationResult.value == null
        enableRegisterButton()
    }

    private fun enableRegisterButton() {
        _registerButtonEnabled.value = emailCorrect && usernameCorrect && passwordCorrect
    }
}
