package com.example.shoe.viewmodel

import androidx.lifecycle.*
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.wj.common.constant.UrlConstant
import com.wj.common.service.ShoeService

class FavouriteModel constructor(userId:Long) : ViewModel() {

    init {
        ARouter.getInstance().inject(this)
    }

    @JvmField
    @Autowired(name = UrlConstant.SERVICE_SHOE)
    var shoeRepository: ShoeService? = null

    // 鞋子集合的观察类
    val shoes: LiveData<List<com.example.entity.data.Shoe>>? = shoeRepository?.getShoesByUserId(userId)
}