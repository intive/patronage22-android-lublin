package com.intive.patronage22.lublin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.intive.patronage22.lublin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}