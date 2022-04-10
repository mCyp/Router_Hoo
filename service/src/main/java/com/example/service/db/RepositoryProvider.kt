package com.example.service.db

import android.content.Context
import com.example.service.db.repository.FavouriteShoeRepository
import com.example.service.db.repository.ShoeRepository
import com.example.service.db.repository.StorageDataRepository
import com.example.service.db.repository.UserRepository

object RepositoryProvider {

    /**
     * 得到用户仓库
     */
    fun providerUserRepository(context: Context): UserRepository {
        return UserRepository.getInstance(AppDataBase.getInstance(context).userDao())
    }

    /**
     * 得到鞋的本地仓库
     */
    fun providerShoeRepository(context: Context): ShoeRepository {
        return ShoeRepository.getInstance(AppDataBase.getInstance(context).shoeDao())
    }

    /**
     * 得到收藏记录的仓库
     */
    fun providerFavouriteShoeRepository(context: Context): FavouriteShoeRepository {
        return FavouriteShoeRepository.getInstance(
            AppDataBase.getInstance(context).favouriteShoeDao()
        )
    }

    fun providerStorageDataRepository(context: Context): StorageDataRepository {
        return StorageDataRepository.getInstance(
            AppDataBase.getInstance(context).storageDataDao()
        )
    }


}