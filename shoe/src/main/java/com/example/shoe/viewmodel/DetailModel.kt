package com.example.shoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.example.service.db.repository.FavouriteShoeRepository
import com.example.service.db.repository.ShoeRepository
import com.wj.common.constant.UrlConstant
import kotlinx.coroutines.launch

class DetailModel constructor(
    private val shoeId: Long,
    val userId: Long
) : ViewModel() {

    @JvmField
    @Autowired(name = UrlConstant.SERVICE_SHOE)
    var shoeRepository: ShoeRepository? = null

    @JvmField
    @Autowired(name = UrlConstant.SERVICE_FAV_SHOE)
    var favouriteShoeRepository: FavouriteShoeRepository? = null

    // 鞋
    val shoe: LiveData<com.example.service.db.data.Shoe>? = shoeRepository?.getShoeById(shoeId)

    // 收藏记录
    val favouriteShoe: LiveData<com.example.service.db.data.FavouriteShoe?>? = favouriteShoeRepository?.findFavouriteShoe(userId, shoeId)

    // 收藏一双鞋
    fun favourite() {
        viewModelScope.launch {
            favouriteShoeRepository?.createFavouriteShoe(userId,shoeId)
        }
    }
}