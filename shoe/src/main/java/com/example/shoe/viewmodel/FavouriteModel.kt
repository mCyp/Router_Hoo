package com.example.shoe.viewmodel

import androidx.lifecycle.*
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.example.service.db.repository.FavouriteShoeRepository
import com.example.service.db.repository.ShoeRepository
import com.wj.common.constant.UrlConstant

class FavouriteModel constructor(userId:Long) : ViewModel() {

    @JvmField
    @Autowired(name = UrlConstant.SERVICE_SHOE)
    var shoeRepository: ShoeRepository? = null

    // 鞋子集合的观察类
    val shoes: LiveData<List<com.example.service.db.data.Shoe>>? = shoeRepository?.getShoesByUserId(userId)
}