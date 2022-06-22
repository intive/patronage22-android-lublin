package com.intive.patronage22.lublin.screens.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.setSupportActionBar(binding.loginToolbar)

        NavigationUI.setupActionBarWithNavController(this, getNavController())
    }

    override fun onSupportNavigateUp(): Boolean {
        return getNavController().navigateUp()
    }

    private fun getNavController(): NavController {
        return this.findNavController(R.id.loginNavHostFragment)
    }
}