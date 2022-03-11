package com.intive.patronage22.lublin.screens.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.repository.model.Product

class HomeListAdapter(private val fragment: HomeFragment, private val products: List<Product>) :
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    class ViewHolder(private val fragment: HomeFragment, itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val productTitleTextView: TextView = itemView.findViewById(R.id.productsListTitle)
        private val productPriceTextView: TextView = itemView.findViewById(R.id.productsListPrice)
        private val productImageView: ImageView = itemView.findViewById(R.id.productImage)

        fun bind(product: Product) {
            productTitleTextView.text = product.name
            productPriceTextView.text = product.price.toString()
            Glide.with(fragment)
                .load(product.imageUrl)
                .placeholder(R.drawable.image_placeholder)
                .fitCenter()
                .into(productImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_single_item, parent, false)

        return ViewHolder(fragment, view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }
}