package com.phanphuongnam.paginganddatabase.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.phanphuongnam.paginganddatabase.R
import com.phanphuongnam.paginganddatabase.domain.Beer

class BeerAdapter : PagingDataAdapter<Beer, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Beer>() {
            override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean =
                oldItem.id == newItem.id &&
                        oldItem.name == newItem.name &&
                        oldItem.tagline == newItem.tagline &&
                        oldItem.imageUrl == newItem.imageUrl &&
                        oldItem.description == newItem.description &&
                        oldItem.firstBrewed == newItem.firstBrewed
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? BeerViewHolder)?.bind(item = getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BeerViewHolder.getInstance(parent)
    }

    /**
     * view holder class
     */
    class BeerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        companion object {
            fun getInstance(parent: ViewGroup): BeerViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item_beer, parent, false)
                return BeerViewHolder(view)
            }
        }

        private var tvName: TextView = view.findViewById(R.id.tv_name)
        private var tvDescription: TextView = view.findViewById(R.id.tv_description)
        private var tvFirstBrewed: TextView = view.findViewById(R.id.tv_first_brewed)
        private var ivBeer: ImageView = view.findViewById(R.id.iv_beer)
        fun bind(item: Beer?) {
            tvName.text = item?.name
            tvDescription.text = item?.description
            tvFirstBrewed.text = item?.firstBrewed
            Glide.with(ivBeer.context)
                .load(item?.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(ivBeer)

        }

    }
}