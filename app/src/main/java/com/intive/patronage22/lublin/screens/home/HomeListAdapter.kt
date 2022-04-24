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
import com.intive.patronage22.lublin.ui.base.ProductsViewModel

class HomeListAdapter(private val productsViewModel: ProductsViewModel) :
    RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    private var products: List<Product> = emptyList()

    fun setProducts(products: List<Product>) {
        this.products = products
    }

    class ViewHolder(
        private val productsViewModel: ProductsViewModel,
        private val binding: HomeSingleItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productsListTitle.text = product.title
            binding.productsListPrice.text = binding.root.context.resources.getString(R.string.product_price, product.price)
            Glide.with(binding.root)
                .load(URL + product.mainPhotoUrl)
                .placeholder(R.drawable.image_placeholder)
                .fitCenter()
                .into(binding.productImage)
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, ProductDetailsActivity::class.java)
                productsViewModel.pack(intent, product)
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

        return ViewHolder(productsViewModel,binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }
}