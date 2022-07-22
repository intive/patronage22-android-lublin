package com.intive.patronage22.lublin.screens.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.intive.patronage22.lublin.R
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

        startListenUsername(binding.editTextUsername)
        startListenPassword(binding.editTextPassword)
        startListenEmail(binding.editTextEmail)

        binding.registerButton.setOnClickListener {
            viewModel.onRegisterButtonClicked(
                binding.editTextUsername.text.toString(),
                binding.editTextEmail.text.toString(),
                binding.editTextPassword.text.toString()
            ) //wyslij toast a pozniej zmien fragment jesli succes
            // mapper daje znac co zrobic z odpowiedzia
            Toast.makeText(context, context?.getString(R.string.not_valid_password_error), Toast.LENGTH_SHORT)
        }

        return binding.root
    }

    private fun startListenUsername(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onUsernameChanged(editText.text.toString())
            }
        }
        editText.doAfterTextChanged { viewModel.onUsernameChanged(editText.text.toString()) }
    }

    private fun startListenPassword(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onPasswordChanged(editText.text.toString())
            }
        }
        editText.doAfterTextChanged { viewModel.onPasswordChanged(editText.text.toString()) }
    }

    private fun startListenEmail(editText: EditText) {
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.onEmailChanged(editText.text.toString())
            }
        }
        editText.doAfterTextChanged { viewModel.onEmailChanged(editText.text.toString()) }
    }

    override fun onDestroy() {
        binding.editTextUsername.onFocusChangeListener = null
        binding.editTextEmail.onFocusChangeListener = null
        binding.editTextPassword.onFocusChangeListener = null
        _binding = null
        super.onDestroy()
    }
}