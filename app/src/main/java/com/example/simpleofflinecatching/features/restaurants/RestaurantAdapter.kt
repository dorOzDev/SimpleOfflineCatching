package com.example.simpleofflinecatching.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpleofflinecatching.data.Restaurant
import com.example.simpleofflinecatching.databinding.RestaurantItemBinding

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.RestaurantsViewHolder>(RestaurantComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {

        val binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RestaurantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {

        val currItem = getItem(position)
        if(currItem != null) {
            holder.bind(currItem)
        }
    }

    class RestaurantsViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(restaurant: Restaurant) {

                binding.apply {
                    Glide.with(itemView)
                        .load(restaurant.logo)
                        .into(imageViewLogo)

                    textViewName.text = restaurant.name
                    textViewAddress.text  = restaurant.address
                    textViewType.text = restaurant.type
                }
            }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {

        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem == newItem
    }

}