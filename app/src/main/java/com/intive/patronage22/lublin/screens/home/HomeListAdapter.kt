package com.intive.patronage22.lublin.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.HomeSingleItemBinding
import com.intive.patronage22.lublin.repository.model.Product

class HomeListAdapter :
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    private var products: List<Product> = emptyList()

    fun setProducts(products: List<Product>) {
        this.products = products
    }

    class ViewHolder(
        private val binding: HomeSingleItemBinding,
        private val urlString: String = "http://proxy-patronageapi.bsolutions.usermd.net/"
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productsListTitle.text = product.title
            binding.productsListPrice.text = product.price.toString()
            Glide.with(binding.root)
                .load(urlString + product.mainPhotoUrl)
                .placeholder(R.drawable.image_placeholder)
                .fitCenter()
                .into(binding.productImage)
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