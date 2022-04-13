package com.wj.common.service

import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.entity.data.FavouriteShoe

interface FavouriteShoeService: IProvider {
    fun findFavouriteShoe(userId:Long,shoeId:Long): LiveData<FavouriteShoe?>
    suspend fun createFavouriteShoe(userId:Long,shoeId: Long)
}