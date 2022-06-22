package com.intive.patronage22.lublin.screens.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.intive.patronage22.lublin.MainActivity
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.buttonLogin.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        binding.registerButton.setOnClickListener {
            this.findNavController().navigate(R.id.registerFragment)
        }
        return binding.root
    }
}