package com.example.simpleofflinecatching.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantsDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}