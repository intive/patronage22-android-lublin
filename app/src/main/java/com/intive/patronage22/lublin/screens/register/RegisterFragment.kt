package com.intive.patronage22.lublin.screens.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.intive.patronage22.lublin.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.registerViewModel = viewModel
        binding.lifecycleOwner = this

        registerUsernameOnFocusChange(binding.editTextUsername)
        registerPasswordOnFocusChange(binding.editTextPassword)
        registerEmailOnFocusChange(binding.editTextEmail)

        return binding.root
    }

    private fun registerUsernameOnFocusChange(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onUsernameChanged(editText.text.toString())
            }
        }
    }

    private fun registerPasswordOnFocusChange(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onPasswordChanged(editText.text.toString())
            }
        }
    }

    private fun registerEmailOnFocusChange(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onEmailChanged(editText.text.toString())
            }
        }
    }

    override fun onDestroy() {
        binding.editTextUsername.onFocusChangeListener = null
        binding.editTextEmail.onFocusChangeListener = null
        binding.editTextPassword.onFocusChangeListener = null
        _binding = null
        super.onDestroy()
    }
}