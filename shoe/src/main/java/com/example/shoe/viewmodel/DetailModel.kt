package com.example.shoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.example.entity.data.FavouriteShoe
import com.example.entity.data.Shoe
import com.wj.common.constant.UrlConstant
import com.wj.common.service.FavouriteShoeService
import com.wj.common.service.ShoeService
import kotlinx.coroutines.launch

class DetailModel constructor(
    private val shoeId: Long,
    val userId: Long
) : ViewModel() {

    init {
        ARouter.getInstance().inject(this)
    }

    @JvmField
    @Autowired(name = UrlConstant.SERVICE_SHOE)
    var shoeRepository: ShoeService? = null

    @JvmField
    @Autowired(name = UrlConstant.SERVICE_FAV_SHOE)
    var favouriteShoeRepository: FavouriteShoeService? = null

    // 鞋
    val shoe: LiveData<Shoe>? = shoeRepository?.getShoeById(shoeId)

    // 收藏记录
    val favouriteShoe: LiveData<FavouriteShoe?>? = favouriteShoeRepository?.findFavouriteShoe(userId, shoeId)

    // 收藏一双鞋
    fun favourite() {
        viewModelScope.launch {
            favouriteShoeRepository?.createFavouriteShoe(userId,shoeId)
        }
    }
}