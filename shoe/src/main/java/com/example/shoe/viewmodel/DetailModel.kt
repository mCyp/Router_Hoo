package com.example.shoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailModel constructor(
    shoeRepository: com.example.service.db.repository.ShoeRepository,
    private val favouriteShoeRepository: com.example.service.db.repository.FavouriteShoeRepository,
    private val shoeId: Long,
    val userId: Long
) :
    ViewModel() {


    // 鞋
    val shoe: LiveData<com.example.service.db.data.Shoe> = shoeRepository.getShoeById(shoeId)

    // 收藏记录
    val favouriteShoe: LiveData<com.example.service.db.data.FavouriteShoe?> = favouriteShoeRepository.findFavouriteShoe(userId, shoeId)

    // 收藏一双鞋
    fun favourite() {
        viewModelScope.launch {
            favouriteShoeRepository.createFavouriteShoe(userId,shoeId)
        }
    }
}