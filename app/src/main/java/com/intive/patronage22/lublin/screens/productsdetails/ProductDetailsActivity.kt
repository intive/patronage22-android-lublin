package com.intive.patronage22.lublin.screens.productsdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.productExtraName
import com.intive.patronage22.lublin.repository.model.Product

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val product: Product? = intent.getParcelableExtra(productExtraName)
    }
}