package com.intive.patronage22.lublin.screens.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.URL
import com.intive.patronage22.lublin.databinding.HomeSingleItemBinding
import com.intive.patronage22.lublin.repository.model.Product
import com.intive.patronage22.lublin.screens.productsdetails.ProductDetailsActivity

class HomeListAdapter :
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    private var products: List<Product> = emptyList()

    fun setProducts(products: List<Product>) {
        this.products = products
    }

    class ViewHolder(
        private val binding: HomeSingleItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productsListTitle.text = product.title
            binding.productsListPrice.text = product.price.toString()
            Glide.with(binding.root)
                .load(URL + product.mainPhotoUrl)
                .placeholder(R.drawable.image_placeholder)
                .fitCenter()
                .into(binding.productImage)
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, ProductDetailsActivity::class.java)
                startActivity(binding.root.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomeSingleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }
}