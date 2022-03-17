package com.intive.patronage22.lublin.screens.categories


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.CategoryListRowBinding

class CategoriesListAdapter(
    private val fragment: CategoriesFragment,
    private val categories: List<String>
) :
    RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {

    class ViewHolder(
        private val fragment: CategoriesFragment,
        private val binding: CategoryListRowBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: String) {
            binding.categoriesListText.text = category
            binding.categoriesListText.setOnClickListener {
                Toast.makeText(fragment.context, "$category Not Implemented", Toast.LENGTH_SHORT)
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

        return ViewHolder(fragment, binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }
}
