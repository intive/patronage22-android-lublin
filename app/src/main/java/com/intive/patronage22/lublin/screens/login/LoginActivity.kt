package com.intive.patronage22.lublin.screens.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.intive.patronage22.lublin.databinding.FragmentLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}