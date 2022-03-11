package com.intive.patronage22.lublin.screens.home

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
import com.intive.patronage22.lublin.repository.model.home.HomeViewModel
import com.intive.patronage22.lublin.screens.categories.CategoriesListAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = HomeViewModel(
                ProductRepositoryMock(requireContext())
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val productListView = view.findViewById<RecyclerView>(R.id.listProducts)
        viewModel.products.observe(viewLifecycleOwner) { products ->
            productListView.adapter = HomeListAdapter(this, products)
        }
        return view
    }



}