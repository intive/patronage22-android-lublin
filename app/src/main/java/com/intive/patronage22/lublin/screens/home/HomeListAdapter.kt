package com.intive.patronage22.lublin.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.HomeSingleItemBinding
import com.intive.patronage22.lublin.repository.model.Product

class HomeListAdapter(private val fragment: HomeFragment, private val products: List<Product>) :
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    class ViewHolder(
        private val fragment: HomeFragment,
        private val binding: HomeSingleItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productsListTitle.text = product.name
            binding.productsListPrice.text = product.price.toString()
            Glide.with(fragment)
                .load(product.imageUrl)
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

        return ViewHolder(fragment, binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }
}