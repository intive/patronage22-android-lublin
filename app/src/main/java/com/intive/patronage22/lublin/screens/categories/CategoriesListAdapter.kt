package com.intive.patronage22.lublin.screens.categories


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.intive.patronage22.lublin.databinding.CategoryListRowBinding
import com.intive.patronage22.lublin.repository.model.Category

class CategoriesListAdapter :
    RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {

    private var categories: List<Category> = emptyList()

    fun setCategories(categories: List<Category>) {
        this.categories = categories
    }

    class ViewHolder(
        private val binding: CategoryListRowBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.categoriesListText.text = category.title
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
