package com.example.shoe.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoe.viewmodel.DetailModel

class FavouriteShoeModelFactory(
    private val shoeId: Long,
    private val userId: Long
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailModel(shoeId, userId) as T
    }
}