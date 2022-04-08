package com.intive.patronage22.lublin.screens.categories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.data.api.RetrofitBuilder
import com.intive.patronage22.lublin.databinding.FragmentCategoriesBinding
import com.intive.patronage22.lublin.ui.base.CategoriesViewModel
import com.intive.patronage22.lublin.ui.base.ViewModelFactory
import com.intive.patronage22.lublin.utils.Status

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    private val factory = ViewModelFactory(RetrofitBuilder.apiService)
    private val viewModel: CategoriesViewModel by viewModels { factory }
    private lateinit var adapter: CategoriesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        val adapter = CategoriesListAdapter()
        binding.listCategories.adapter = adapter
        this.adapter = adapter
        setupObservers(binding.listCategories)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupObservers(listCategories: RecyclerView) {
        viewModel.getAllCategories().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        listCategories.visibility = View.VISIBLE
                        adapter.apply {
                            setCategories(resource.data!!)
                            notifyDataSetChanged()
                        }
                    }
                    Status.ERROR -> {
                        listCategories.visibility = View.VISIBLE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        listCategories.visibility = View.GONE
                    }
                }
            }
        }
    }

}