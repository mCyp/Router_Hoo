package com.example.service.db.repository

import androidx.lifecycle.LiveData
import com.example.service.db.dao.FavouriteShoeDao
import com.example.service.db.dao.ShoeDao
import com.example.service.db.data.FavouriteShoe
import com.example.service.db.data.Shoe
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.util.*

class FavouriteShoeRepository private constructor(private val favouriteShoeDao: FavouriteShoeDao) {

    /**
     * 查看某个用户是否有喜欢记录
     */
    fun findFavouriteShoe(userId:Long,shoeId:Long):LiveData<FavouriteShoe?>
            = favouriteShoeDao.findFavouriteShoeByUserIdAndShoeId(userId, shoeId)

    /**
     * 收藏一双鞋
     */
    suspend fun createFavouriteShoe(userId:Long,shoeId: Long){
        withContext(IO){
            favouriteShoeDao.insertFavouriteShoe(FavouriteShoe(shoeId,userId, Calendar.getInstance()))
        }
    }

    companion object {
        @Volatile
        private var instance: FavouriteShoeRepository? = null

        fun getInstance(favouriteShoeDao: FavouriteShoeDao): FavouriteShoeRepository =
            instance ?: synchronized(this) {
                instance
                    ?: FavouriteShoeRepository(favouriteShoeDao).also {
                        instance = it
                    }
            }

    }
}