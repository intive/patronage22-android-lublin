package com.intive.patronage22.lublin.screens.home

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
import com.intive.patronage22.lublin.databinding.FragmentHomeBinding
import com.intive.patronage22.lublin.ui.base.ProductsViewModel
import com.intive.patronage22.lublin.ui.base.ViewModelFactory
import com.intive.patronage22.lublin.utils.Status

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val factory = ViewModelFactory(RetrofitBuilder.apiService)
    private val viewModel: ProductsViewModel by viewModels { factory }
    private lateinit var adapter: HomeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val adapter = HomeListAdapter(viewModel)
        binding.listProducts.adapter = adapter
        this.adapter = adapter
        setupObservers(binding.listProducts)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupObservers(listProducts: RecyclerView) {
        viewModel.getAllProducts().observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        listProducts.visibility = View.VISIBLE
                        adapter.apply {
                            setProducts(resource.data!!)
                            notifyDataSetChanged()
                        }
                    }
                    Status.ERROR -> {
                        listProducts.visibility = View.VISIBLE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        listProducts.visibility = View.GONE
                    }
                }
            }
        }
    }
}