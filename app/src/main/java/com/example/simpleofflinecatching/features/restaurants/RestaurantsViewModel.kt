package com.example.simpleofflinecatching.features.restaurants

import androidx.lifecycle.*
import com.example.simpleofflinecatching.api.RestaurantApi
import com.example.simpleofflinecatching.data.Restaurant
import com.example.simpleofflinecatching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(repository: RestaurantRepository): ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()

}