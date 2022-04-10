package com.example.shoe.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoe.viewmodel.DetailModel

class FavouriteShoeModelFactory(
    private val shoeRepository: com.example.service.db.repository.ShoeRepository
    , private val favouriteShoeRepository: com.example.service.db.repository.FavouriteShoeRepository
    , private val shoeId: Long
    , private val userId: Long
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailModel(shoeRepository, favouriteShoeRepository, shoeId, userId) as T
    }
}