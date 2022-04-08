package com.intive.patronage22.lublin.screens.categories


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.intive.patronage22.lublin.databinding.CategoryListRowBinding

class CategoriesListAdapter :
    RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {

    private var categories: List<String> = emptyList()

    fun setCategories(categories: List<String>) {
        this.categories = categories
    }

    class ViewHolder(
        private val binding: CategoryListRowBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: String) {
            binding.categoriesListText.text = category
            binding.categoriesListText.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "$category Not Implemented",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CategoryListRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }
}
