package com.intive.patronage22.lublin.screens.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.repository.CategoryRepositoryMock
import com.intive.patronage22.lublin.repository.ProductRepositoryMock
import com.intive.patronage22.lublin.repository.model.categories.CategoriesViewModel

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    private lateinit var viewModel: CategoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = CategoriesViewModel(
            CategoryRepositoryMock(
                ProductRepositoryMock(requireContext())
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        val categoriesListView = view.findViewById<RecyclerView>(R.id.listCategories)
        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            categoriesListView.adapter = CategoriesListAdapter(requireContext(), categories)
        }
        return view
    }


}