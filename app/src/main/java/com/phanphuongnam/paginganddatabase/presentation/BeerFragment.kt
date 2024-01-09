package com.phanphuongnam.paginganddatabase.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.phanphuongnam.paginganddatabase.databinding.FragmentBeerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BeerFragment: Fragment() {
    private lateinit var adapter: BeerAdapter
    private lateinit var loaderStateAdapter: BeerLoadStateAdapter


    private var _binding: FragmentBeerBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBeerBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMembers()
        setUpViews()
        val viewModel: BeerViewModel by viewModels()
        lifecycleScope.launch {
            viewModel.beerPagingFlow.distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun initMembers() {
        adapter = BeerAdapter()
        loaderStateAdapter = BeerLoadStateAdapter { adapter.retry() }
    }

    private fun setUpViews() {
        binding.rvBeerList.adapter = adapter.withLoadStateFooter(loaderStateAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
