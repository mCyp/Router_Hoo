package com.example.shoe.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoe.viewmodel.FavouriteModel

class FavouriteModelFactory(
    private val userId:Long
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavouriteModel(userId) as T
    }
}