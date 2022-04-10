package com.example.shoe.viewmodel

import android.content.Context
import com.wj.common.constant.BaseConstant
import com.wj.common.util.AppPrefsUtils
import com.example.shoe.viewmodel.factory.*

/**
 * ViewModel提供者
 */
object CustomViewModelProvider {

    fun providerShoeModel(context: Context): ShoeModelFactory {
        val repository: com.example.service.db.repository.ShoeRepository = com.example.service.db.RepositoryProvider.providerShoeRepository(context)
        return ShoeModelFactory(repository)
    }

    fun providerFavouriteModel(context: Context): FavouriteModelFactory {
        val repository: com.example.service.db.repository.ShoeRepository = com.example.service.db.RepositoryProvider.providerShoeRepository(context)
        val userId:Long = AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
        return FavouriteModelFactory(repository,userId)
    }

    fun providerMeModel(context: Context):MeModelFactory{
        val repository: com.example.service.db.repository.UserRepository = com.example.service.db.RepositoryProvider.providerUserRepository(context)
        return MeModelFactory(repository)
    }

    /**
     * @shoeId 鞋子的Id
     * @userId 用户的Id
     */
    fun providerDetailModel(context: Context, shoeId: Long, userId: Long): FavouriteShoeModelFactory {
        val repository: com.example.service.db.repository.ShoeRepository = com.example.service.db.RepositoryProvider.providerShoeRepository(context)
        val favShoeRepository: com.example.service.db.repository.FavouriteShoeRepository = com.example.service.db.RepositoryProvider.providerFavouriteShoeRepository(context)
        return FavouriteShoeModelFactory(repository, favShoeRepository, shoeId, userId)
    }

    fun provideStorageDataModel(context: Context):StorageModelFactory{
        val repository: com.example.service.db.repository.StorageDataRepository = com.example.service.db.RepositoryProvider.providerStorageDataRepository(context)
        return StorageModelFactory(repository)
    }
}