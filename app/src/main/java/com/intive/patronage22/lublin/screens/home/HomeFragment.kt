package com.intive.patronage22.lublin.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.intive.patronage22.lublin.R
import com.intive.patronage22.lublin.databinding.FragmentHomeBinding
import com.intive.patronage22.lublin.repository.ProductRepositoryMock
import com.intive.patronage22.lublin.repository.model.home.HomeViewModel

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
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.products.observe(viewLifecycleOwner) { products ->
            binding.listProducts.adapter = HomeListAdapter(this, products)
        }
        return binding.root
    }
}