package com.intive.patronage22.lublin.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intive.patronage22.lublin.RegisterFlowValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val registerFlowValidator: RegisterFlowValidator
) : ViewModel() {

    private val usernameCorrect: Boolean
        get() = _usernameValidationResult.value == null

    private val passwordCorrect: Boolean
        get() = _passwordValidationResult.value == null

    private val _usernameValidationResult = MutableLiveData<String>()
    val usernameValidationResult: LiveData<String> = _usernameValidationResult

    private val _passwordValidationResult = MutableLiveData<String>()
    val passwordValidationResult: LiveData<String> = _passwordValidationResult

    private val _loginButtonEnabled = MutableLiveData<Boolean>()
    val loginButtonEnabled: LiveData<Boolean> = _loginButtonEnabled

    fun onUsernameChanged(username: String) {
        _usernameValidationResult.value = registerFlowValidator.validateUsername(username)
        enableLoginButton()
    }

    fun onPasswordChanged(password: String) {
        _passwordValidationResult.value = registerFlowValidator.validatePassword(password)
        enableLoginButton()
    }

    private fun enableLoginButton() {
        _loginButtonEnabled.value = usernameCorrect && passwordCorrect
    }
}