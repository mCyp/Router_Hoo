package com.example.shoe.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoe.viewmodel.FavouriteModel

class FavouriteModelFactory(
    private val repository: com.example.service.db.repository.ShoeRepository
,private val userId:Long
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavouriteModel(repository,userId) as T
    }
}