package com.example.shoe.viewmodel

import android.content.Context
import com.wj.common.constant.BaseConstant
import com.wj.common.util.AppPrefsUtils
import com.example.shoe.viewmodel.factory.*

/**
 * ViewModel提供者
 */
object CustomViewModelProvider {

    fun providerShoeModel(): ShoeModelFactory {
        return ShoeModelFactory()
    }

    fun providerFavouriteModel(): FavouriteModelFactory {
        val userId:Long = AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
        return FavouriteModelFactory(userId)
    }

    fun providerMeModel():MeModelFactory{
        return MeModelFactory()
    }

    /**
     * @shoeId 鞋子的Id
     * @userId 用户的Id
     */
    fun providerDetailModel(shoeId: Long, userId: Long): FavouriteShoeModelFactory {
        return FavouriteShoeModelFactory(shoeId, userId)
    }

    fun provideStorageDataModel():StorageModelFactory{
        return StorageModelFactory()
    }
}