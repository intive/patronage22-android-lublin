package com.intive.patronage22.lublin.screens.productsdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.ActivityMainBinding
import com.intive.patronage22.lublin.databinding.ActivityProductDetailsBinding
import com.intive.patronage22.lublin.productExtraName
import com.intive.patronage22.lublin.repository.model.Product

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product: Product? = intent.getParcelableExtra(productExtraName)
    }
}