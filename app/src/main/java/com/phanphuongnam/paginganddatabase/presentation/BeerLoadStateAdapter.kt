package com.phanphuongnam.paginganddatabase.presentation

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class BeerLoadStateAdapter( private val retry: () -> Unit
) : LoadStateAdapter<BeerLoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = BeerLoadStateViewHolder(parent, retry)

    override fun onBindViewHolder(
        holder: BeerLoadStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)
}