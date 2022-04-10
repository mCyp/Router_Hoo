package com.example.shoe.viewmodel

import androidx.lifecycle.*

class FavouriteModel constructor(shoeRepository: com.example.service.db.repository.ShoeRepository, userId:Long) : ViewModel() {

    // 鞋子集合的观察类
    val shoes: LiveData<List<com.example.service.db.data.Shoe>> = shoeRepository.getShoesByUserId(userId)

}