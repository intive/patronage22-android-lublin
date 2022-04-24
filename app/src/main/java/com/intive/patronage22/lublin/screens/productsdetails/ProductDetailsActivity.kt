package com.intive.patronage22.lublin.screens.productsdetails

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.URL
import com.intive.patronage22.lublin.data.api.RetrofitBuilder
import com.intive.patronage22.lublin.databinding.ActivityProductDetailsBinding
import com.intive.patronage22.lublin.repository.model.Product
import com.intive.patronage22.lublin.ui.base.ProductsViewModel
import com.intive.patronage22.lublin.ui.base.ViewModelFactory

class ProductDetailsActivity : AppCompatActivity() {

    private val factory = ViewModelFactory(RetrofitBuilder.apiService)
    private val viewModel: ProductsViewModel by viewModels { factory }

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = viewModel.getProductFrom(intent)!!
        Glide.with(binding.root)
            .load(URL + product.mainPhotoUrl)
            .placeholder(R.drawable.image_placeholder)
            .fitCenter()
            .into(binding.productImage)
        binding.productName.text = product.title
        binding.productPrice.text = binding.root.context.resources.getString(R.string.product_price, product.price)
        binding.productDescription.text = product.description
    }
}