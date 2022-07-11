package com.intive.patronage22.lublin.screens.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.intive.patronage22.lublin.MainActivity
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private var usernameWatcher: TextWatcher? = null
    private var passwordWatcher: TextWatcher? = null

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        binding.buttonLogin.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        binding.registerButton.setOnClickListener {
            this.findNavController().navigate(R.id.registerFragment)
        }

        return binding.root
    }

    private fun startListenUsername(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onUsernameChanged(editText.text.toString())
            }
            val usernameWatcher = object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable) {
                    viewModel.onUsernameChanged(s.toString())
                }
            }
            editText.addTextChangedListener(usernameWatcher)
        }
    }

    private fun startListenPassword(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onPasswordChanged(editText.text.toString())
            }
        }
        val passwordWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                viewModel.onPasswordChanged(s.toString())
            }
        }
        editText.addTextChangedListener(passwordWatcher)
    }

    override fun onResume() {
        super.onResume()
        startListenUsername(binding.editTextUsername)
        startListenPassword(binding.editTextPassword)
    }

    override fun onPause() {
        binding.editTextUsername.removeTextChangedListener(usernameWatcher)
        binding.editTextPassword.removeTextChangedListener(passwordWatcher)
        super.onPause()
    }

    override fun onDestroy() {
        binding.editTextUsername.onFocusChangeListener = null
        binding.editTextPassword.onFocusChangeListener = null
        _binding = null
        super.onDestroy()
    }
}