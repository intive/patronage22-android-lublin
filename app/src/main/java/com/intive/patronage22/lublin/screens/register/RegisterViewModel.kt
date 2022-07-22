package com.intive.patronage22.lublin.screens.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intive.patronage22.lublin.RegisterFlowValidator
import com.intive.patronage22.lublin.repository.model.registration.SignUpException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerFlowValidator: RegisterFlowValidator,
    private val signUpUseCase: SignUpUseCase,
) : ViewModel() {

    private val usernameCorrect: Boolean
        get() = _usernameValidationResult.value == null

    private val passwordCorrect: Boolean
        get() = _passwordValidationResult.value == null

    private val emailCorrect: Boolean
        get() = _emailValidationResult.value == null

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
        enableRegisterButton()
    }

    fun onPasswordChanged(password: String) {
        _passwordValidationResult.value = registerFlowValidator.validatePassword(password)
        enableRegisterButton()
    }

    fun onEmailChanged(email: String) {
        _emailValidationResult.value = registerFlowValidator.validateEmail(email)
        enableRegisterButton()
    }

    private fun enableRegisterButton() {
        _registerButtonEnabled.value = emailCorrect && usernameCorrect && passwordCorrect
    }

    fun onRegisterButtonClicked(name: String, email: String, password: String) {
        registerUser(name, email, password)
    }

    private fun registerUser(
        name: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            try {
                signUpUseCase.execute(name, email, password)
            } catch (e: SignUpException) {

            }
        }
    }
}