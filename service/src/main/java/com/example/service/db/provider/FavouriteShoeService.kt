package com.example.service.db.provider

import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.service.db.data.FavouriteShoe

interface FavouriteShoeService: IProvider {
    fun findFavouriteShoe(userId:Long,shoeId:Long): LiveData<FavouriteShoe?>
    suspend fun createFavouriteShoe(userId:Long,shoeId: Long)
}